package mz.org.fgh.sifmoz.backend.reports.stock


import mz.org.fgh.sifmoz.backend.multithread.ReportSearchParams

interface IStockReportService {

    StockReportTemp get(Serializable id)

    List<StockReportTemp> list(Map args)

    Long count()

    StockReportTemp delete(Serializable id)

    StockReportTemp save(StockReportTemp stockReport)

    void processReportRecords(ReportSearchParams searchParams)


}
