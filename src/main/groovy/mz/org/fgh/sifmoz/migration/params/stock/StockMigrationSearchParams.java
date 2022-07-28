package mz.org.fgh.sifmoz.migration.params.stock;

import mz.org.fgh.sifmoz.migration.base.search.params.AbstractMigrationSearchParams;
import mz.org.fgh.sifmoz.migration.entity.patient.PatientMigrationRecord;
import mz.org.fgh.sifmoz.migration.entity.stock.StockCenterMigrationRecord;
import mz.org.fgh.sifmoz.migration.entity.stock.StockMigrationRecord;
import mz.org.fgh.sifmoz.migration.params.PatientMigrationSearchParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.grails.web.json.JSONArray;

import java.util.Arrays;
import java.util.List;

public class StockMigrationSearchParams extends AbstractMigrationSearchParams<StockMigrationRecord> {

    static Logger logger = LogManager.getLogger(StockMigrationSearchParams.class);
    @Override
    public List<StockMigrationRecord> doSearch(long limit) {
        JSONArray jsonArray = getRestServiceProvider().get("/stock_migration_vw?limit=100");
        this.searchResults.clear();
        StockMigrationRecord[] stockMigrationRecords = gson.fromJson(jsonArray.toString(), StockMigrationRecord[].class);
        logger.info(jsonArray.toString());

        if (stockMigrationRecords != null && stockMigrationRecords.length > 0) {
            this.searchResults.addAll(Arrays.asList(stockMigrationRecords));
        }
        return this.searchResults;
    }
}
