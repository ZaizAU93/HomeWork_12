package ValidContr;

public class Validity {
    private String[] docnum;

    public Validity(String[] docnum) {
        this.docnum = docnum;
    }

    public String[] getDocnum() {
        return docnum;
    }

    public void setDocnum(String[] docnum) {
        this.docnum = docnum;
    }

    public boolean validity_Check_SpecialCharacters(String[] docnum) {
        String SpecialCharachters = "[!@#$%^&*(),.?\":{}|<>]";
        for (int i = 0; i < docnum.length; i++)
            for (int j = 0; j < docnum[j].length(); j++) {
                if (docnum[i].contains(SpecialCharachters)){
                    System.out.println("Несоответсвие служебным символам");
                }
            }
        return true;
    }


    public boolean validity_Check_Length(){
        boolean isValid = true;
        int k = 0;
        for(int i = 0; i < docnum.length; i++){
            if (docnum[i].length() != 15){
                System.out.println(" Несоответсвие длинне"+ docnum[i]);
                isValid = false;
            k++;
            }
        }
        System.out.println( "счетчик "+k);
        return isValid;
    }

    public boolean validity_Check_Name(String[] docnum){
        String doc = "docnum";
        String contract = "contract";
        for(int i = 0; i < docnum.length; i++){
            if (docnum[i].substring(0,6) != doc || docnum[i].substring(0,9) != contract){
                System.out.println("Невалидное название документа");
            }
        }
        return false;
    }

}
