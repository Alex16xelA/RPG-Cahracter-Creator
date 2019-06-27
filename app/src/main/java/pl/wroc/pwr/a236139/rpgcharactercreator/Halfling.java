package pl.wroc.pwr.a236139.rpgcharactercreator;

import static java.lang.Math.floor;

public class Halfling implements Character{

    private String[] infoArray;
    private int[] statsArray;
    private boolean female;
    private Dice dice1, dice2, dice3, dice4;

    public Halfling(){
        dice1 = new Dice(10);
        dice2 = new Dice (100);
        dice3 = new Dice(20);
        dice4 = new Dice(12);

        statsArray = new int[16];
        infoArray = new String[8];

        female = false;
    }

    public void setStatsArray(){

        int pomocnicza;

        pomocnicza = dice3.roll();
        statsArray[0]= pomocnicza+10;
        pomocnicza = dice3.roll();
        statsArray[1]= pomocnicza+30;
        pomocnicza = dice3.roll();
        statsArray[2]= pomocnicza+10;
        pomocnicza = dice3.roll();
        statsArray[3]= pomocnicza+10;
        pomocnicza = dice3.roll();
        statsArray[4]= pomocnicza+30;
        pomocnicza = dice3.roll();
        statsArray[5]= pomocnicza+20;
        pomocnicza = dice3.roll();
        statsArray[6]= pomocnicza+20;
        pomocnicza = dice3.roll();
        statsArray[7]= pomocnicza+30;

        statsArray[8]= 1;
        pomocnicza = dice1.roll();
        statsArray[9]= getLive(pomocnicza);
        statsArray[10]= getCheck(statsArray[2]);
        statsArray[11]= getCheck(statsArray[3]);
        statsArray[12]= 4;
        statsArray[13]= 0;
        statsArray[14]= 0;
        pomocnicza = dice1.roll();
        statsArray[15]= getLuck(pomocnicza);

    }

    @Override
    public int getStatsArray(int a) {
        return statsArray[a];
    }

    private int getLuck(int pomocnicza) {
        if(pomocnicza<5) return 2;
        else if(pomocnicza<10) return 2;
        else return 3;
    }

    private int getCheck(int i) {
        double mFloor = i/10;
        int mResult = (int) floor(mFloor);
        return mResult;
    }

    private int getLive(int pomocnicza) {
        if(pomocnicza<4) return 8;
        else if(pomocnicza<7) return 9;
        else if(pomocnicza<10) return 10;
        else return 11;
    }

    public void setInfoArray(){

        int helper;

        helper = dice3.roll();
        infoArray[0] = getAge(helper);
        helper = dice1.roll();
        infoArray[1] = getEve(helper);
        helper = dice4.roll();
        infoArray[2] = getWeight(helper);
        helper = dice1.roll();
        infoArray[3] = getHair(helper);
        helper = dice3.roll();
        infoArray[4] = getHeight(helper);
        helper = dice1.roll();
        infoArray[5] = getSiblings(helper);
        helper = dice3.roll();
        infoArray[6] = getStar(helper);
        helper = dice2.roll();
        if(helper<51) infoArray[7] = "The Moot";
        else {
            helper = dice4.roll();
            infoArray[7] = getPlace(helper);
        }

    }

    @Override
    public String getInfoArray(int a) {
        return infoArray[a];
    }

    private String getSiblings(int helper) {
        if(helper==1) return "1";
        else if(helper<4) return "2";
        else if(helper<6) return "3";
        else if(helper<8) return "4";
        else if(helper<10) return "5";
        else return "6";
    }

    private String getHeight(int helper) {
        int h;
        if(female==true) {
            h=100+helper;
            return Integer.toString(h);
        }
        else {
            h=110+helper;
            return Integer.toString(h);
        }
    }

    private String getHair(int helper) {
        switch(helper) {
            case 1:
                return "Ash Blond";
            case 2:
                return "Corn";
            case 3:
                return "Blond";
            case 4:
                return "Blond";
            case 5:
                return "Copper";
            case 6:
                return "Red";
            case 7:
                return "Light Brown";
            case 8:
                return "Brown";
            case 9:
                return "Dark Brown";
            case 10:
                return "Black";
            default:
                return "Copper";
        }
    }

    private String getWeight(int helper) {
        switch(helper) {
            case 1:
                return "35";
            case 2:
                return "35";
            case 3:
                return "40";
            case 4:
                return "40";
            case 5:
                return "45";
            case 6:
                return "45";
            case 7:
                return "50";
            case 8:
                return "50";
            case 9:
                return "55";
            case 10:
                return "60";
            case 11:
                return "65";
            case 12:
                return "70";
            default:
                return "48";
        }
    }

    private String getEve(int helper) {
        switch(helper) {
            case 1:
                return "Blue";
            case 2:
                return "Hazel";
            case 3:
                return "Hazel";
            case 4:
                return "Light Brown";
            case 5:
                return "Light Brown";
            case 6:
                return "Brown";
            case 7:
                return "Brown";
            case 8:
                return "Dark Brown";
            case 9:
                return "Dark Brown";
            case 10:
                return "Dark Brown";
            default:
                return "Light Brown";
        }
    }

    private String getPlace(int helper) {
        switch(helper) {
            case 1:
                return "Averland";
            case 2:
                return "Hochland";
            case 3:
                return "Middenland";
            case 4:
                return "Nordland";
            case 5:
                return "Ostermark";
            case 6:
                return "Ostland";
            case 7:
                return "Reikland";
            case 8:
                return "Stirland";
            case 9:
                return "Talabecland";
            case 10:
                return "Wissenland";
            default:
                return "Ostermark";
        }
    }

    private String getAge(int helper) {
        switch(helper){
            case 1:
                return "20";
            case 2:
                return "22";
            case 3:
                return "24";
            case 4:
                return "26";
            case 5:
                return "28";
            case 6:
                return "30";
            case 7:
                return "32";
            case 8:
                return "34";
            case 9:
                return "36";
            case 10:
                return "38";
            case 11:
                return "40";
            case 12:
                return "42";
            case 13:
                return "44";
            case 14:
                return "46";
            case 15:
                return "48";
            case 16:
                return "50";
            case 17:
                return "52";
            case 18:
                return "54";
            case 19:
                return "56";
            case 20:
                return "60";
            default:
                return "38";
        }
    }

    private String getStar(int helper) {
        switch(helper) {
            case 1:
                return "Wymund the Anchorite";
            case 2:
                return "The Big Cross";
            case 3:
                return "The Limnner's Line";
            case 4:
                return "Gnuthus the Oks";
            case 5:
                return "Dragomas the Drake";
            case 6:
                return "The Gloaming";
            case 7:
                return "Grungni's Baldric";
            case 8:
                return "Mammit the Vise";
            case 9:
                return "Mummit the Fool";
            case 10:
                return "The Two Bullocks";
            case 11:
                return "The Dancer";
            case 12:
                return "The Drammer";
            case 13:
                return "The Piper";
            case 14:
                return "Vobist the Faint";
            case 15:
                return "The Broken Card";
            case 16:
                return "The Greased Goat";
            case 17:
                return "Rhya's Cauldron";
            case 18:
                return "Cackelfax the Cockerel";
            case 19:
                return "The Bonesaw";
            case 20:
                return "The Witchling Star";
            default:
                return "The Two Bullocks";
        }
    }

    public void setSex(){
        female = true;
    }
}
