package com.example.projekat;

public class Trening {

    private String vrsta;
    private String opisVezbi;

    public static final Trening[] vezbe = {
            new Trening("Gornji deo tela",
                    "1. PODIZANJE IZ IZDRŽAJA GORE-DOLE  30sec\n" +
                    "2. SKLEKOVI  30sec\n" +
                    "3. LEĐNJACI - PODIZANJE RUKU PORED TELA 30sec\n" +
                    "4. LEĐNJACI - 2+1 (ZADŽI 3sec)  30sec\n" +
                    "5. SKLEK + DODIRIVANJE RAMENA  30sec\n" +
                    "6. BOČNI IZDRŽAJ + PULSIRANJE 30sec SS\n" +
                    "7. PROPADANJA D.O.\n" +
                    "8. PLANINAR NA UZVIŠENJU SA JEDNOM NOGOM  x12SN\n" +
                    "9. PLANK CRUNCHES  30sec"),
            new Trening("Donji deo tela", "1. ČUČANJ 90%  x30\n" +
                    "2. ISKORAK U STRANU x15SN\n" +
                    "3. HODAJUĆI ISKORACI x30\n" +
                    "4. HAMSTRING CURL x15\n" +
                    "5. 2x PULS + SKOK UNAPRED x20\n" +
                    "6. PENJANJE NA UZVIŠENJE + ISKORAK UNAZAD x12SN\n" +
                    "7. MONSTER WALK  x20\n" +
                    "8. BURPEE + 2x SKOK-ČUČANJ  x10\n" +
                    "9. PULSIRAJUĆI ISKORACIv  x30sec SN\n" +
                    "10. ČUČANJ LEVO-DESNO + SKOK x12"),
            new Trening("HIIT trening za celo telo", "1. 5x PLANINAR + BURPEE  30sec\n" +
                    "2. TRBUŠNJACI NAIZMENIČNO PODIZANJE NOGU 30sec\n" +
                    "3. 5sec VISOKI SKIP + BURPEE  30sec\n" +
                    "4. TRBUŠNJACI DODIRIVANJE NOGU   30sec\n" +
                    "5. SKOK ČUČANJ + PODIZANJE NOGU  30sec\n" +
                    "6. PLANINAR NA UZVIŠENJU SA JEDNOM NOGOM x12SN\n" +
                    "7. BURPEE + SKOK U STRANU  30sec\n" +
                    "8. PLANK CRUNCHES  30sec\n" +
                    "9. VISOKI SKIP  30sec"),
            new Trening("Stomak", "1. KLASIČNI TRBUŠNJACI x20\n" +
                    "2. BICYCLE CRUNCHES x20\n" +
                    "3. DEAD BUG  x20\n" +
                    "4. CRUNCH CLAPS x20\n" +
                    "5. RUSSIAN TWIST 30sec\n" +
                    "6. SKLOPKE x15"),
            new Trening("CORE trening", "1. BEAR CRAWL  30sec\n" +
                    "2. KNEE TUCKS  30sec\n" +
                    "3. BODY SAW  30sec\n" +
                    "4. USKI + ŠIROKI SKLEK  30sec\n" +
                    "5. LEĐNJACI - 2 + 1 (ZADRŽI 3sec)  30sec\n" +
                    "6. IZDRŽAJ U SKLEKU  30sec\n" +
                    "7. PLANINAR NA UZVIŠENJU SA JEDNOM NOGOM  x12SN\n" +
                    "8. LEĐNJACI + SKLEK  30sec"),
    };

    public Trening (String vrsta, String opisVezbi){
        this.vrsta = vrsta;
        this.opisVezbi = opisVezbi;
    }


    public String getVrsta() {
        return vrsta;
    }

    public String getOpisVezbi() {
        return opisVezbi;
    }
}
