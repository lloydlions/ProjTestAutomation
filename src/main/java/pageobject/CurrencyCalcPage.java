package pageobject;

public class CurrencyCalcPage {

    private String inputSell = "//input[contains(@data-ng-model,'currencyExchangeVM.filter.from')]";
    private String drpDownSellCurrency = "//div[contains(@data-ng-model,'currencyExchangeVM.filter.from')]";
    private String inputBuy = "//input[contains(@data-ng-model,'currencyExchangeVM.filter.to_amount')]";
    private String drpDownBuyCurrency = "//div[contains(@data-ng-model,'currencyExchangeVM.filter.to')]";
    private String btnRates = "//button[contains(@data-ng-click,'currencyExchangeVM.filterExchangeRates()')]";
    private String btnClearFilter = "//button[contains(@data-ng-click,'currencyExchangeVM.clearFilter()')]";
    private String dropUpFlag = "//span[contains(@class,'js-localization-popover')]";

}
