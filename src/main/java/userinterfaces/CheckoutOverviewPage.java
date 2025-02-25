package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutOverviewPage {

    public static final Target TXT_ITEM_TOTAL = Target.the("item total")
            .locatedBy("//div[@class='summary_subtotal_label']");

    public static final Target TXT_TAX = Target.the("tax")
            .locatedBy("//div[@class='summary_tax_label']");

    public static final Target TXT_TOTAL = Target.the("total")
            .locatedBy("//div[@class='summary_total_label']");
}