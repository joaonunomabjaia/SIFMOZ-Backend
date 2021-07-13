package mz.org.fgh.sifmoz.backend.stockinventory

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional
import mz.org.fgh.sifmoz.backend.drug.Drug
import mz.org.fgh.sifmoz.backend.stock.IStockService
import mz.org.fgh.sifmoz.backend.stock.Stock
import mz.org.fgh.sifmoz.backend.stockadjustment.IInventoryStockAdjustmentService

import mz.org.fgh.sifmoz.backend.stockadjustment.InventoryStockAdjustment
import mz.org.fgh.sifmoz.backend.stockadjustment.StockAdjustment

@Transactional
@Service(Inventory)
abstract class InventoryService implements IInventoryService{
    IInventoryStockAdjustmentService inventoryStockAdjustmentService
    IStockService stockService

    @Override
    void processInventoryAdjustments(Inventory inventory) {

        for (StockAdjustment adjustment : inventory.getAdjustments()) {
            inventoryStockAdjustmentService.processAdjustment(adjustment)
        }
    }

    @Override
    void initInventory(Inventory inventory) {
        List<Stock> drugStocks = new ArrayList<>();

        for (Drug drug : inventory.getInventoryDrugs()) {
            drugStocks.addAll(stockService.findAllOnceReceivedByDrug(drug))
        }

        initInventoryAdjustments(inventory, drugStocks)

    }

    private void initInventoryAdjustments(Inventory inventory, List<Stock> stocks) {
        List<StockAdjustment> adjustments = new ArrayList<>();

        for(Stock stock : stocks){
            adjustments.add(initAdjustment(inventory, stock))
        }
        inventory.setAdjustments(adjustments as Set<StockAdjustment>)
    }

    private StockAdjustment initAdjustment(Inventory inventory, Stock stock) {
        StockAdjustment adjustment = new InventoryStockAdjustment(inventory, stock)
        inventoryStockAdjustmentService.save(adjustment)
        return adjustment
    }
}
