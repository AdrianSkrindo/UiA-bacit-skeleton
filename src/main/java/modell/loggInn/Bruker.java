package modell.loggInn;
//Her har vi laget en modell klasse for Ansatt

import java.sql.Connection;

public class Bruker {
        int AnsattId;
        String AnsattFornavn;
        String AnsattEtternavn;
        String AnsattEmail;
        String AnsattTlf;
        String Passord;
        boolean AnsattSertifsert;
        boolean Admin;
        boolean AnsattUnion;

    public Bruker(){
    }

    public Bruker(int AnsattId, String AnsattFornavn, String AnsattEtternavn, String AnsattEmail, String AnsattTlf, String Passord,
                   boolean AnsattSertifsert, boolean Admin, boolean AnsattUnion) {
        this.AnsattId = AnsattId;
        this.AnsattFornavn = AnsattFornavn;
        this.AnsattEtternavn = AnsattEtternavn;
        this.AnsattEmail = AnsattEmail;
        this.AnsattTlf = AnsattTlf;
        this.Passord = Passord;
        this.AnsattSertifsert = AnsattSertifsert;
        this.Admin = Admin;
        this.AnsattUnion = AnsattUnion;
    }

    /*gettere og settere

    public int getAnsattId(){
        return AnsattId;
    }
    public void setAnsattID(int AnsattId){
        this.AnsattId = AnsattId;
    }

    public String getAnsattFornavn(){
        return AnsattFornavn;
    }
    public void setAnsattFornavn(String AnsattFornavn){
        this.AnsattFornavn = AnsattFornavn;
    }

    public String getAnsattEtternavn(){
        return AnsattEtternavn;
    }
    public void setAnsattEtternavn(String AnsattEtternavn){
        this.AnsattEtternavn = AnsattEtternavn;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getTelefon(){
        return telefon;
    }
    public void setTelefon(String telefon){
        this.telefon = telefon;
    }

    public String getPassord(){
        return passord;
    }
    public void setPassord(String passord){
        this.passord = passord;
    }

    public boolean getSertifisert(){
        return sertifisert;
    }
    public void setAnsattSertifsert(boolean AnsattSertifsert){
        this.AnsattSertifsert = AnsattSertifsert;
    }

    public boolean getUnion(){
        return AnsattUnion;
    }
    public void setUniont(){
        this.AnsattUnion = AnsattUnion;
    }
*/

    public static class BrukerDB {
        //Con er for tilknyttning til DB
        Connection con;

        //Lager en Bruker DB med en tilkobling til DB
        public BrukerDB(Connection con) {
            this.con = con;
        }

    }
}