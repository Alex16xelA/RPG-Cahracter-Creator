package pl.wroc.pwr.a236139.rpgcharactercreator;

import static java.lang.Math.floor;

public class Dwar implements Character{

    private String[] infoArray;
    private int[] statsArray;
    private boolean female;
    private Dice dice1, dice2, dice3, dice4;

    public Dwar(){
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
        statsArray[0]= pomocnicza+30;
        pomocnicza = dice3.roll();
        statsArray[1]= pomocnicza+20;
        pomocnicza = dice3.roll();
        statsArray[2]= pomocnicza+20;
        pomocnicza = dice3.roll();
        statsArray[3]= pomocnicza+30;
        pomocnicza = dice3.roll();
        statsArray[4]= pomocnicza+10;
        pomocnicza = dice3.roll();
        statsArray[5]= pomocnicza+20;
        pomocnicza = dice3.roll();
        statsArray[6]= pomocnicza+20;
        pomocnicza = dice3.roll();
        statsArray[7]= pomocnicza+10;

        statsArray[8]= 1;
        pomocnicza = dice1.roll();
        statsArray[9]= getLive(pomocnicza);
        statsArray[10]= getCheck(statsArray[2]);
        statsArray[11]= getCheck(statsArray[3]);
        statsArray[12]= 3;
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
        if(pomocnicza<5) return 1;
        else if(pomocnicza<10) return 2;
        else return 3;
    }

    private int getCheck(int i) {
        double mFloor = i/10;
        int mResult = (int) floor(mFloor);
        return mResult;
    }

    private int getLive(int pomocnicza) {
        if(pomocnicza<4) return 11;
        else if(pomocnicza<7) return 12;
        else if(pomocnicza<10) return 13;
        else return 14;
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
        if(helper<31) {
            helper = dice4.roll();
            infoArray[7] = getPlace(helper);
        }
        else infoArray[7] = getPlace2(helper);

    }

    @Override
    public String getInfoArray(int a) {
        return infoArray[a];
    }

    private String getPlace2(int helper) {
        if(helper<41) return "Karak Norn (Grey Mountains)";
        else if(helper<51) return "Karak Izor (The Voults)";
        else if(helper<61) return "Karak Hirn (Black Mountains)";
        else if(helper<71) return "Karak Kadrin (Word's Edge Mountains)";
        else if(helper<81) return "Karak Karas-A-Karak (Word's Edge Mountains)";
        else if(helper<91) return "Karak Zhufbar (Word's Edge Mountains)";
        else return "Karak Barak Varr (The Black Gulf)";
    }

    private String getSiblings(int helper) {
        if(helper==1) return "0";
        else if(helper<6) return "1";
        else if(helper<10) return "2";
        else return "3";
    }

    private String getHeight(int helper) {
        int h;
        if(female==true) {
            h=130+helper;
            return Integer.toString(h);
        }
        else {
            h=145+helper;
            return Integer.toString(h);
        }
    }

    private String getHair(int helper) {
        switch(helper) {
            case 1:
                return "Ash Blond";
            case 2:
                return "Blond";
            case 3:
                return "Red";
            case 4:
                return "Copper";
            case 5:
                return "Light Brown";
            case 6:
                return "Brown";
            case 7:
                return "Brown";
            case 8:
                return "Dark Brown";
            case 9:
                return "Blue Black";
            case 10:
                return "Black";
            default:
                return "Brown";
        }
    }

    private String getWeight(int helper) {
        switch(helper) {
            case 1:
                return "45";
            case 2:
                return "50";
            case 3:
                return "55";
            case 4:
                return "60";
            case 5:
                return "65";
            case 6:
                return "70";
            case 7:
                return "75";
            case 8:
                return "80";
            case 9:
                return "85";
            case 10:
                return "90";
            case 11:
                return "95";
            case 12:
                return "100";
            default:
                return "68";
        }
    }

    private String getEve(int helper) {
        switch(helper) {
            case 1:
                return "Pale-Gray";
            case 2:
                return "Blue";
            case 3:
                return "Copper";
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
                return "Purple";
            default:
                return "Dark Brown";
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
                return "25";
            case 3:
                return "30";
            case 4:
                return "35";
            case 5:
                return "40";
            case 6:
                return "45";
            case 7:
                return "50";
            case 8:
                return "55";
            case 9:
                return "60";
            case 10:
                return "65";
            case 11:
                return "70";
            case 12:
                return "75";
            case 13:
                return "80";
            case 14:
                return "85";
            case 15:
                return "90";
            case 16:
                return "95";
            case 17:
                return "100";
            case 18:
                return "105";
            case 19:
                return "110";
            case 20:
                return "115";
            default:
                return "68";
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
