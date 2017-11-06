package seedu.address.logic.commands;

/**
 * Method for application to call out for different QR Functions
 */
//@@author danielweide
public class QrGenSaveContactCommand {
    /**
     * Method to Generate SaveContact for Phone QRCode
     */
    public String qrSaveContact(String phoneNum, String contactName, String contactEmail) {
        String qrCodeA = "http://";
        String qrCodeB = "api.qrserver.com/";
        String qrCodeC = "v1/";
        String qrCodeD = "create-qr-code/";
        String qrCodeE = "?color=000000";
        String qrCodeF = "&bgcolor=FFFFFF";
        String qrCodeG = "&data=";
        String qrCodeH = "BEGIN";
        String qrCodeI = "%3";
        String qrCodeJ = "AVCARD";
        String qrCodeK = "%0";
        String qrCodeL = "AVERSION";
        String qrCodeM = "%3A";
        String qrCodeN = "2.1";
        String qrCodeO = "%0AFN";
        String qrCodeP = "%3A";
        String qrLineA = qrCodeA + qrCodeB + qrCodeC + qrCodeD + qrCodeE + qrCodeF + qrCodeE
                + qrCodeF + qrCodeG + qrCodeH + qrCodeI + qrCodeJ + qrCodeK + qrCodeL + qrCodeM
                + qrCodeN + qrCodeO + qrCodeP;
        String newContactName = contactName.replace(',', '+');
        String qrPartbCodeA = "%0";
        String qrPartbCodeB = "AN";
        String qrPartbCodeC = "%3A";
        String qrPartbCodeD = "%3B";
        String qrLineB = qrPartbCodeA + qrPartbCodeB + qrPartbCodeC + qrPartbCodeD;

        String qrPartcCodeA = "%0";
        String qrPartcCodeB = "ATEL";
        String qrPartcCodeC = "%3";
        String qrPartcCodeD = "BWORK";
        String qrPartcCodeE = "%3";
        String qrPartcCodeF = "BVOICE";
        String qrPartcCodeG = "%3A";

        String qrLineC = qrPartcCodeA + qrPartcCodeB + qrPartcCodeC
                + qrPartcCodeD + qrPartcCodeE + qrPartcCodeF + qrPartcCodeG;
        String qrPartdCodeA = "%0A";
        String qrPartdCodeB = "EMAIL";
        String qrPartdCodeC = "%3";
        String qrPartdCodeD = "BWORK";
        String qrPartdCodeE = "%3";
        String qrPartdCodeF = "BINTERNET";
        String qrPartdCodeG = "%3A";
        String qrLineD = qrPartdCodeA + qrPartdCodeB + qrPartdCodeC
                + qrPartdCodeD + qrPartdCodeE + qrPartdCodeF + qrPartdCodeG;
        String qrParteCodeA = "%0";
        String qrParteCodeB = "AEND";
        String qrParteCodeC = "%3A";
        String qrParteCodeD = "VCARD";
        String qrParteCodeE = "%0A";
        String qrParteCodeF = "&qzone=1";
        String qrParteCodeG = "&margin=0";
        String qrParteCodeH = "&size=";
        String qrParteCodeI = "500x500";
        String qrParteCodeJ = "&ecc=L";
        String qrLineE = qrParteCodeA + qrParteCodeB
                + qrParteCodeC + qrParteCodeD + qrParteCodeE
                + qrParteCodeF + qrParteCodeG + qrParteCodeH
                + qrParteCodeI + qrParteCodeJ;
        String fullQr = qrLineA + newContactName + qrLineB + newContactName
                + qrLineC + phoneNum + qrLineD + contactEmail + qrLineE;

        return fullQr;
    }
}
