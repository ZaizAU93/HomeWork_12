package ValidContr;

import java.util.Arrays;

public class Validity {
    public String strResult = "";

    public String[] getDocnum() {
        return docnum;
    }

    public  String[] docnum;
    public String string = "%s - Невалидный контракт";
    public Validity(String[] docnum) {
        this.docnum = docnum;
    }


    public boolean validity_Check_SpecialCharacters(String str) {
            for (char c : str.toCharArray()) {
                if (!(Character.isLetter(c) || Character.isDigit(c) || c == '\r')) {
                    return true;
                }
            }
        return false;
    }



    public boolean validity_Check_Length(String str){
            if (str.trim().length() != 15){
                return true;
            }
        return false;
    }


    public boolean validity_Check_Name(String str){
        String doc = "docnum";
        String contract = "contract";
            if (!(str.substring(0,6).equals(doc) || str.substring(0,8).equals(contract))){
                return true;
            }
        return false;
    }

}
