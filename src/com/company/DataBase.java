package com.company;

import java.io.*;
import java.util.*;


public class DataBase {
    private int counter=0;
    Scanner input = new Scanner(System.in);
    ArrayList<String> UnitName = new ArrayList<String>();
    ArrayList<String> UnitSurName = new ArrayList<String>();
    ArrayList<Integer> UnitAge = new ArrayList<Integer>();
    ArrayList<String> UnitSex = new ArrayList<String>();
    ArrayList<Integer> UnitPoints = new ArrayList<Integer>();

    private void whereAreYou(int column, int line ){
        String pointerPossition="";
        switch(column) {
            case 0:
                pointerPossition="Imie";
                break;
            case 1:
                pointerPossition="Nazwisko";
                break;
            case 2:
                pointerPossition="Plec";
                break;
            case 3:
                pointerPossition="Wiek";
                break;
            case 4:
                pointerPossition="Punkty";
                break;
        }
        System.out.println("Kolumnie: "+pointerPossition);
        System.out.println("Wiersz: "+(line+1));
        switch (column)
        {
            case 0:
                System.out.println("Dana na pozycji: "+UnitName.get(line));
                break;
            case 1:
                System.out.println("Dana na pozycji: "+UnitSurName.get(line));
                break;
            case 2:
                System.out.println("Dana na pozycji: "+UnitSex.get(line));
                break;
            case 3:
                System.out.println("Dana na pozycji: "+UnitAge.get(line));
                break;
            case 4:
                System.out.println("Dana na pozycji: "+UnitPoints.get(line));
                break;
        }
    }

    DataBase() throws IOException
    {

        FileReader fileReaderName = new FileReader("UnitName.txt");
        BufferedReader bufferedReaderName = new BufferedReader(fileReaderName);

        String textLine = bufferedReaderName.readLine();
        while(textLine!=null) {
            UnitName.add(textLine);
            textLine = bufferedReaderName.readLine();
            counter++;
        }

        bufferedReaderName.close();

        FileReader fileReaderSurName= new FileReader("UnitSurName.txt");
        BufferedReader bufferedReaderSurName = new BufferedReader(fileReaderSurName);

        textLine = bufferedReaderSurName.readLine();
        while(textLine!=null) {
            UnitSurName.add(textLine);
            textLine = bufferedReaderSurName.readLine();
        }

        bufferedReaderSurName.close();

        FileReader fileReaderSex= new FileReader("UnitSex.txt");
        BufferedReader bufferedReaderSex = new BufferedReader(fileReaderSex);

        textLine = bufferedReaderSex.readLine();
        while(textLine!=null) {
            UnitSex.add(textLine);
            textLine = bufferedReaderSex.readLine();
        }

        bufferedReaderSex.close();

        FileReader fileReaderAge= new FileReader("UnitAge.txt");
        BufferedReader bufferedReaderAge = new BufferedReader(fileReaderAge);

        textLine = bufferedReaderAge.readLine();
        while(textLine!=null) {
            UnitAge.add(Integer.valueOf(textLine));
            textLine = bufferedReaderAge.readLine();
        }

        bufferedReaderAge.close();

        FileReader fileReaderPoints= new FileReader("UnitPoints.txt");
        BufferedReader bufferedReaderPoints = new BufferedReader(fileReaderPoints);

        textLine = bufferedReaderPoints.readLine();
        while(textLine!=null) {
            UnitPoints.add(Integer.valueOf(textLine));
            textLine = bufferedReaderPoints.readLine();
        }

        bufferedReaderPoints.close();
    }

    public void endProgram () throws FileNotFoundException
    {
        PrintWriter saveUnitName = new PrintWriter("UnitName.txt");
        for(String s:UnitName)
        saveUnitName.println(s);
        saveUnitName.close();

        PrintWriter saveUnitSurName = new PrintWriter("UnitSurName.txt");
        for(String s:UnitSurName)
        saveUnitSurName.println(s);
        saveUnitSurName.close();

        PrintWriter saveSex = new PrintWriter("UnitSex.txt");
        for(String s:UnitSex)
        saveSex.println(s);
        saveSex.close();

        PrintWriter saveAge = new PrintWriter("UnitAge.txt");
        for(Integer s:UnitAge)
        saveAge.println(s);
        saveAge.close();

        PrintWriter savePoints = new PrintWriter("UnitPoints.txt");
        for(Integer s:UnitPoints)
        savePoints.println(s);
        savePoints.close();
    }

    public void readDatabase(){
        int x=0;
        int y=0;
        int end=0;
        String move="";
        do {
            System.out.println("");
            whereAreYou(x,y);
            System.out.println("1.Przesuń w lewo.  2.Przesuń w góre.  3.Przesuń w dół.  4.Przesuń w prawo.  5.Wyjdz.");
            System.out.print("Twój wybór: ");
            move=input.next();
            switch (move){
                case "1":
                    if(x==0)
                    {break;}
                    else
                    {x--;}
                    break;
                case "2":
                    if(y==0)
                    {break;}
                    else
                    {y--;}
                    break;
                case "3":
                    if(y==(counter-1))
                    {break;}
                    else
                    {y++;}
                    break;
                case "4":
                    if(x==4)
                    {break;}
                    else
                    {x++;}
                    break;
                case "5":
                    end=Integer.valueOf(move);
                    break;
                default:
                    break;
            }
        }while(end!=5);
    }
    public void writeEnityToDatabase(){
        String name="";
        String surName="";
        String sex="";
        int age=0;
        int points=-1;
        String menu="";
        String sexVerification="";
        int ageVerification=0;
        int pointsVerification=0;
        int close=0;

        do {
            System.out.println("Imie: " + name);
            System.out.println("Nazwiwsko: " + surName);
            System.out.println("Plec: " + sex);
            System.out.println("Wiek: " + age);
            System.out.println("Punkty: " + points);
            System.out.println("1.Dodaj imie.   2.Dodaj nazwisko.   3.Dodaj plec.   4.Dodaj wiek(16-100).   5.Dodaj punkty(0-100).   6.Zatwierdz(minimum imie, nazwisko i plec).    7.Wyjdz.");
            System.out.print("Twój wybór: ");
            menu=input.next();
            switch (menu)
            {
                case "1":
                    System.out.print("Podaj imie: ");
                    name="";
                    String hName=input.next();
                    name = hName.substring(0, 1).toUpperCase() + hName.substring(1);
                    System.out.println(" ");
                    break;
                case "2":
                    System.out.print("Podaj nazwisko: ");
                    surName="";
                    String hSurName=input.next();
                    surName = hSurName.substring(0, 1).toUpperCase() + hSurName.substring(1);
                    System.out.println(" ");
                    break;
                case "3":
                    System.out.print("Podaj plec(M/K): ");
                    sex="";
                    sexVerification=input.next();
                    sexVerification=sexVerification.toUpperCase();
                    sexVerification=sexVerification.substring(0,1);
                    if(sexVerification.equals("M") || sexVerification.equals("K"))
                    {sex=sexVerification;
                    System.out.println(" ");}
                    else
                    {System.out.println(" ");
                    break;}
                    break;
                case "4":
                    System.out.print("Podaj wiek: ");
                    age=0;
                    try{
                        ageVerification=Integer.valueOf(input.next());
                    }catch(NumberFormatException e)
                    {
                        System.out.println(" ");
                        break;
                    }
                    if(ageVerification>15 && ageVerification<101)
                    {age=ageVerification;
                    System.out.println(" ");}
                    else
                    {System.out.println(" ");
                        break;}
                    break;
                case "5":
                    System.out.print("Podaj punkty: ");
                    points=-1;
                    try{
                        pointsVerification=Integer.valueOf(input.next());
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println(" ");
                        break;
                    }
                    if(pointsVerification>=0 && pointsVerification<=100)
                    {points=pointsVerification;
                    System.out.println(" ");}
                    else
                    {System.out.println(" ");
                        break;}
                    break;
                case "6":
                    if(name!="" && surName!="" && sex!="" )
                    {
                        name.substring(0,1).toUpperCase();
                        surName.substring(0,1).toUpperCase();
                        UnitName.add(name);
                        UnitSurName.add(surName);
                        UnitSex.add(sex);

                        if(age==0)
                        {UnitAge.add(0);}
                        else
                        {UnitAge.add(age);}

                        if(points==-1)
                        {UnitPoints.add(-1);}
                        else
                        {UnitPoints.add(points);}
                        close=Integer.valueOf(menu);
                        counter++;
                    }
                    else
                    {
                        System.out.println("Podaj Imię, Nazwisko i Płeć.");
                        System.out.println("");
                        break;
                    }
                case "7":
                    close=6;
                    break;
                default:
                    System.out.println(" ");
                    break;
            }
        }while(close!=6);
    }
    public void deleteOneFrame(){
        int x=0;
        int y=0;
        int end=0;
        String del="";
        String deletedFrame="BD";
        int deletedAge=0;
        int deletedPoints=-1;
        String sexVerification;
        int ageVerification;
        int pointsVerification;
        String move="";
        do {
            System.out.println("");
            whereAreYou(x,y);
            System.out.println("1.Przesuń w lewo.  2.Przesuń w góre.  3.Przesuń w dół.  4.Przesuń w prawo. " +
                    " 5.Usuń zawartość.  6.Edytuj zawartość.  7.Usuń cały wpis.   8.Wyjdz.");
            System.out.print("Twój wybór: ");
            move=input.next();
            switch (move){
                case "1":
                    if(x==0)
                    {break;}
                    else
                    {x--;}
                    break;
                case "2":
                    if(y==0)
                    {break;}
                    else
                    {y--;}
                    break;
                case "3":
                    if(y==(counter-1))
                    {break;}
                    else
                    {y++;}
                    break;
                case "4":
                    if(x==4)
                    {break;}
                    else
                    {x++;}
                    break;
                case "5":
                    switch (x)
                    {
                        case 0:
                            System.out.println("Nie można usunąć.");
                            break;
                        case 1:
                            System.out.println("Nie można usunąć.");
                            break;
                        case 2:
                            System.out.println("Nie można usunąć.");
                            break;
                        case 3:
                            UnitAge.set(y,deletedAge);
                            break;
                        case 4:
                            UnitPoints.set(y,deletedPoints);
                            break;
                    }
                    break;
                case "6":
                    switch (x)
                    {
                        case 0:
                            System.out.print("Podaj imie: ");
                            String hName=input.next();
                            String name = hName.substring(0, 1).toUpperCase() + hName.substring(1);
                            UnitName.set(y,name);
                            System.out.println(" ");
                            break;
                        case 1:
                            System.out.print("Podaj nazwisko: ");
                            String hSurName=input.next();
                            String surName = hSurName.substring(0, 1).toUpperCase() + hSurName.substring(1);
                            UnitSurName.set(y,surName);
                            System.out.println(" ");
                            break;
                        case 2:
                            System.out.print("Podaj plec(M/K): ");
                            sexVerification=input.next();
                            sexVerification=sexVerification.toUpperCase();
                            sexVerification=sexVerification.substring(0,1);
                            if(sexVerification.equals("M") || sexVerification.equals("K"))
                            {UnitSex.set(y,sexVerification);
                                System.out.println(" ");}
                            else
                            {break;}

                            break;
                        case 3:
                            System.out.print("Podaj wiek(>15): ");
                            try{
                                ageVerification=Integer.valueOf(input.next());
                            }catch(NumberFormatException e)
                            {
                                System.out.println(" ");
                                break;
                            }
                            if(ageVerification>15 && ageVerification<101)
                            {UnitAge.set(y,ageVerification);
                                System.out.println(" ");}
                            else
                            {break;}
                            break;
                        case 4:
                            System.out.print("Podaj punkty(0-100): ");
                            try{
                                pointsVerification=Integer.valueOf(input.next());
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println(" ");
                                break;
                            }
                            if(pointsVerification>=0 && pointsVerification<=100)
                            {UnitPoints.set(y,pointsVerification);
                                System.out.println(" ");}
                            else
                            {break;}
                            break;
                    }
                    break;
                case "7":
                    del="";
                    System.out.println("Czy na pewno chcesz usunąć?");
                    System.out.print("Tak/Nie: ");
                    del=input.next();
                    del=del.toUpperCase();
                    if(del.equals("TAK"))
                    {
                        UnitName.remove(y);
                        UnitSurName.remove(y);
                        UnitSex.remove(y);
                        UnitAge.remove(y);
                        UnitPoints.remove(y);
                        counter--;
                    }
                    else
                    break;
                case "8":
                    end=Integer.valueOf(move);
                    break;
                default:
                    break;
            }
        }while(end!=8);
    }
    public void searchFrame() {
        ArrayList<Integer> DataFound= new ArrayList<Integer>();
        int x=0;
        int end=0;
        int loop;
        int lend;
        boolean direction=true;
        String choose;
        String dataFrame="";
        String searchFrame="";
        String move="";
        do{
            String pointerPossition="";
            switch(x) {
                case 0:
                    pointerPossition="Imie";
                    break;
                case 1:
                    pointerPossition="Nazwisko";
                    break;
                case 2:
                    pointerPossition="Plec";
                    break;
                case 3:
                 pointerPossition="Wiek";
                    break;
                case 4:
                    pointerPossition="Punkty";
                    break;
            }
            System.out.println(" ");
            System.out.println("Jesteś w kolumnie: "+pointerPossition);
            System.out.println("1.Przesuń w lewo.   2.Przesuń w prawo.  3.Wyszukaj  4.Wyjdz.");
            System.out.print("Twój wybór: ");
            move=input.next();
            switch (move) {
                case "1":
                    if (x == 0) {break;
                    } else {x--;}
                    break;
                case "2":
                    if (x == 4) {break;
                    } else {x++;}
                    break;
                case "3":
                    switch (x){
                        case 0:
                            System.out.print("Podaj imie: ");
                            break;
                        case 1:
                            System.out.print("Podaj nazwisko: ");
                            break;
                        case 2:
                            System.out.print("Podaj dane(M/K): ");
                            break;
                        case 3:
                            System.out.print("Podaj dane(15-100, 0-brak danych): ");
                            break;
                        case 4:
                            System.out.print("Podaj dane(0-100, \"-1\"-brak danych): ");
                            break;
                    }
                    searchFrame=input.next();
                    searchFrame=searchFrame.toUpperCase();
                    switch (x) {
                        case 0:
                            loop=0;
                            choose="";
                            lend=0;
                            dataFrame="";
                            DataFound.clear();
                            if(counter>0)
                            {
                                while(loop<(counter))
                                {
                                    dataFrame=UnitName.get(loop);
                                    dataFrame=dataFrame.toUpperCase();
                                    if(searchFrame.equals(dataFrame))
                                    {
                                        DataFound.add(loop);
                                    }
                                    loop++;
                                }
                                if(DataFound.isEmpty())
                                {
                                    System.out.println(" ");
                                    System.out.println("Nie mogę nic takiego znaleźć.");
                                }
                                else
                                {
                                    loop=0;
                                    do{
                                        try {
                                            System.out.println(" ");
                                            System.out.println("Imię: "+UnitName.get(DataFound.get(loop)));
                                            System.out.println("Nazwisko: "+UnitSurName.get(DataFound.get(loop)));
                                            System.out.println("Plec: "+UnitSex.get(DataFound.get(loop)));
                                            System.out.println("Wiek: "+UnitAge.get(DataFound.get(loop)));
                                            System.out.println("Punkty: "+UnitPoints.get(DataFound.get(loop)));
                                            System.out.println("1.Dalej.    2.Wcześniej.    3.Koniec.");
                                            System.out.print("Twój wybór: ");
                                            choose=input.next();
                                            switch (choose)
                                            {
                                                case "1":
                                                    direction=true;
                                                    loop++;
                                                    break;
                                                case "2":
                                                    direction=false;
                                                    loop--;
                                                    break;
                                                case "3":
                                                    lend=Integer.valueOf(choose);
                                                    break;
                                                default:
                                                 break;
                                            }
                                        }catch (IndexOutOfBoundsException e)
                                        {
                                            if(direction==true)
                                                loop--;
                                            else
                                                loop++;
                                        }

                                    }while(lend!=3);
                                }
                            }
                            else
                            {
                                System.out.println(" ");
                                System.out.print("Brak Danych.");
                                break;
                            }
                            break;
                        case 1:
                            loop=0;
                            choose="";
                            lend=0;
                            dataFrame="";
                            DataFound.clear();
                            if(counter>0)
                            {
                                while(loop<(counter))
                                {
                                    dataFrame=UnitSurName.get(loop);
                                    dataFrame=dataFrame.toUpperCase();
                                    if(searchFrame.equals(dataFrame))
                                    {
                                        DataFound.add(loop);
                                    }
                                    loop++;
                                }
                                if(DataFound.isEmpty())
                                {
                                    System.out.println(" ");
                                    System.out.println("Nie mogę nic takiego znaleźć.");
                                }
                                else
                                {
                                    loop=0;
                                    do{
                                        try {
                                            System.out.println(" ");
                                            System.out.println("Imię: "+UnitName.get(DataFound.get(loop)));
                                            System.out.println("Nazwisko: "+UnitSurName.get(DataFound.get(loop)));
                                            System.out.println("Plec: "+UnitSex.get(DataFound.get(loop)));
                                            System.out.println("Wiek: "+UnitAge.get(DataFound.get(loop)));
                                            System.out.println("Punkty: "+UnitPoints.get(DataFound.get(loop)));
                                            System.out.println("1.Dalej.    2.Wcześniej.    3.Koniec.");
                                            System.out.print("Twój wybór: ");
                                            choose=input.next();
                                            switch (choose)
                                            {
                                                case "1":
                                                    direction=true;
                                                    loop++;
                                                    break;
                                                case "2":
                                                    direction=false;
                                                    loop--;
                                                    break;
                                                case "3":
                                                    lend=Integer.valueOf(choose);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }catch (IndexOutOfBoundsException e)
                                        {
                                            if(direction==true)
                                                loop--;
                                            else
                                                loop++;
                                        }

                                    }while(lend!=3);
                                }
                            }
                            else
                            {
                                System.out.println(" ");
                                System.out.print("Brak Danych.");
                                break;
                            }
                            break;
                        case 2:
                            loop=0;
                            choose="";
                            lend=0;
                            dataFrame="";
                            DataFound.clear();
                            if(counter>0)
                            {
                                while(loop<(counter))
                                {
                                    dataFrame=UnitSex.get(loop);
                                    dataFrame=dataFrame.toUpperCase();
                                    if(searchFrame.equals(dataFrame))
                                    {
                                        DataFound.add(loop);
                                    }
                                    loop++;
                                }
                                if(DataFound.isEmpty())
                                {
                                    System.out.println(" ");
                                    System.out.println("Nie mogę nic takiego znaleźć.");
                                }
                                else
                                {
                                    loop=0;
                                    do{
                                        try {
                                            System.out.println(" ");
                                            System.out.println("Imię: "+UnitName.get(DataFound.get(loop)));
                                            System.out.println("Nazwisko: "+UnitSurName.get(DataFound.get(loop)));
                                            System.out.println("Plec: "+UnitSex.get(DataFound.get(loop)));
                                            System.out.println("Wiek: "+UnitAge.get(DataFound.get(loop)));
                                            System.out.println("Punkty: "+UnitPoints.get(DataFound.get(loop)));
                                            System.out.println("1.Dalej.    2.Wcześniej.    3.Koniec.");
                                            System.out.print("Twój wybór: ");
                                            choose=input.next();
                                            switch (choose)
                                            {
                                                case "1":
                                                    direction=true;
                                                    loop++;
                                                    break;
                                                case "2":
                                                    direction=false;
                                                    loop--;
                                                    break;
                                                case "3":
                                                    lend=Integer.valueOf(choose);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }catch (IndexOutOfBoundsException e)
                                        {
                                            if(direction==true)
                                                loop--;
                                            else
                                                loop++;
                                        }

                                    }while(lend!=3);
                                }
                            }
                            else
                            {
                                System.out.println(" ");
                                System.out.print("Brak Danych.");
                                break;
                            }
                            break;
                        case 3:
                            loop=0;
                            choose="";
                            lend=0;
                            dataFrame="";
                            DataFound.clear();
                            if(counter>0)
                            {
                                while(loop<(counter))
                                {
                                    dataFrame=Integer.toString(UnitAge.get(loop));
                                    dataFrame=dataFrame.toUpperCase();
                                    if(searchFrame.equals(dataFrame))
                                    {
                                        DataFound.add(loop);
                                    }
                                    loop++;
                                }
                                if(DataFound.isEmpty())
                                {
                                    System.out.println(" ");
                                    System.out.println("Nie mogę nic takiego znaleźć.");
                                }
                                else
                                {
                                    loop=0;
                                    do{
                                        try {
                                            System.out.println(" ");
                                            System.out.println("Imię: "+UnitName.get(DataFound.get(loop)));
                                            System.out.println("Nazwisko: "+UnitSurName.get(DataFound.get(loop)));
                                            System.out.println("Plec: "+UnitSex.get(DataFound.get(loop)));
                                            System.out.println("Wiek: "+UnitAge.get(DataFound.get(loop)));
                                            System.out.println("Punkty: "+UnitPoints.get(DataFound.get(loop)));
                                            System.out.println("1.Dalej.    2.Wcześniej.    3.Koniec.");
                                            System.out.print("Twój wybór: ");
                                            choose=input.next();
                                            switch (choose)
                                            {
                                                case "1":
                                                    direction=true;
                                                    loop++;
                                                    break;
                                                case "2":
                                                    direction=false;
                                                    loop--;
                                                    break;
                                                case "3":
                                                    lend=Integer.valueOf(choose);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }catch (IndexOutOfBoundsException e)
                                        {
                                            if(direction==true)
                                                loop--;
                                            else
                                                loop++;
                                        }

                                    }while(lend!=3);
                                }
                            }
                            else
                            {
                                System.out.println(" ");
                                System.out.print("Brak Danych.");
                                break;
                            }
                            break;
                        case 4:
                            loop=0;
                            choose="";
                            lend=0;
                            dataFrame="";
                            DataFound.clear();
                            if(counter>0)
                            {
                                while(loop<(counter))
                                {
                                    dataFrame=Integer.toString(UnitPoints.get(loop));
                                    dataFrame=dataFrame.toUpperCase();
                                    if(searchFrame.equals(dataFrame))
                                    {
                                        DataFound.add(loop);
                                    }
                                    loop++;
                                }
                                if(DataFound.isEmpty())
                                {
                                    System.out.println(" ");
                                    System.out.println("Nie mogę nic takiego znaleźć.");
                                }
                                else
                                {
                                    loop=0;
                                    do{
                                        try {
                                            System.out.println(" ");
                                            System.out.println("Imię: "+UnitName.get(DataFound.get(loop)));
                                            System.out.println("Nazwisko: "+UnitSurName.get(DataFound.get(loop)));
                                            System.out.println("Plec: "+UnitSex.get(DataFound.get(loop)));
                                            System.out.println("Wiek: "+UnitAge.get(DataFound.get(loop)));
                                            System.out.println("Punkty: "+UnitPoints.get(DataFound.get(loop)));
                                            System.out.println("1.Dalej.    2.Wcześniej.    3.Koniec.");
                                            System.out.print("Twój wybór: ");
                                            choose=input.next();
                                            switch (choose)
                                            {
                                                case "1":
                                                    direction=true;
                                                    loop++;
                                                    break;
                                                case "2":
                                                    direction=false;
                                                    loop--;
                                                    break;
                                                case "3":
                                                    lend=Integer.valueOf(choose);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }catch (IndexOutOfBoundsException e)
                                        {
                                            if(direction==true)
                                                loop--;
                                            else
                                                loop++;
                                        }

                                    }while(lend!=3);
                                }
                            }
                            else
                            {
                                System.out.println(" ");
                                System.out.print("Brak Danych.");
                                break;
                            }
                            break;
                    }
                    break;
                case "4":
                    end = Integer.valueOf(move);
                    break;
                default:
                    System.out.println(" ");
                    break;
            }
        }while(end!=4);
    }
    public void sortDatabase(){
        int x=0;
        int end=0;
        String move="";
        String localHelpName="";
        String localHelpSurName="";
        String localHelpSex="";
        int localIntHelpAge=0;
        int localIntHelpPoints=0;
        int sortHelp=0;
        do {
            String pointerPossition = "";
            switch (x) {
                case 0:
                    pointerPossition = "Imie";
                    break;
                case 1:
                    pointerPossition = "Nazwisko";
                    break;
                case 2:
                    pointerPossition = "Plec";
                    break;
                case 3:
                    pointerPossition = "Wiek";
                    break;
                case 4:
                    pointerPossition = "Punkty";
                    break;
            }
            if(x==2)
            {
                System.out.println(" ");
                System.out.println("Jesteś w kolumnie: " + pointerPossition);
                System.out.println("1.Przesuń w lewo.    2.Przesuń w prawo.   3.Kobiety->Mezczysni.   4.Mezczyzni->Kobiety.    5.Wyjdz.");
                System.out.print("Twój wybór: ");
                move=input.next();
            }
            else
            {
                System.out.println(" ");
                System.out.println("Jesteś w kolumnie: " + pointerPossition);
                System.out.println("1.Przesuń w lewo.    2.Przesuń w prawo.   3.Sortuj rosnąco.   4.Sortuj malejąco.    5.Wyjdz.");
                System.out.print("Twój wybór: ");
                move=input.next();
            }
            switch (move)
            {
                case "1":
                    if (x == 0) {break;
                    } else {x--;}
                    break;
                case "2":
                    if (x == 4) {break;
                    } else {x++;}
                    break;
                case "3":
                    switch (x)
                    {
                        case 0:
                            localHelpName="";
                            localHelpSurName="";
                            localHelpSex="";
                            localIntHelpAge=0;
                            localIntHelpPoints=-1;
                            sortHelp=0;
                            for(int i=0;i<counter;i++)
                            {
                                sortHelp=i;
                                for(int j=i+1;j<counter;j++)
                                {
                                   if(UnitName.get(j).compareTo(UnitName.get(sortHelp))<0)
                                       sortHelp=j;
                                }
                                localHelpName=UnitName.get(sortHelp);
                                UnitName.set(sortHelp,UnitName.get(i));
                                UnitName.set(i,localHelpName);

                                localHelpSurName=UnitSurName.get(sortHelp);
                                UnitSurName.set(sortHelp,UnitSurName.get(i));
                                UnitSurName.set(i,localHelpSurName);

                                localHelpSex=UnitSex.get(sortHelp);
                                UnitSex.set(sortHelp,UnitSex.get(i));
                                UnitSex.set(i,localHelpSex);

                                localIntHelpAge = UnitAge.get(sortHelp);
                                UnitAge.set(sortHelp, UnitAge.get(i));
                                UnitAge.set(i, localIntHelpAge);

                                localIntHelpPoints = UnitPoints.get(sortHelp);
                                UnitPoints.set(sortHelp, UnitPoints.get(i));
                                UnitPoints.set(i, localIntHelpPoints);
                            }
                            System.out.println("Posortowano rosnąco.");
                            break;
                        case 1:
                            localHelpName="";
                            localHelpSurName="";
                            localHelpSex="";
                            localIntHelpAge=0;
                            localIntHelpPoints=-1;
                            sortHelp=0;
                            for(int i=0;i<counter;i++)
                            {
                                sortHelp=i;
                                for(int j=i+1;j<counter;j++)
                                {
                                    if(UnitSurName.get(j).compareTo(UnitSurName.get(sortHelp))<0)
                                        sortHelp=j;
                                }
                                localHelpName=UnitName.get(sortHelp);
                                UnitName.set(sortHelp,UnitName.get(i));
                                UnitName.set(i,localHelpName);

                                localHelpSurName=UnitSurName.get(sortHelp);
                                UnitSurName.set(sortHelp,UnitSurName.get(i));
                                UnitSurName.set(i,localHelpSurName);

                                localHelpSex=UnitSex.get(sortHelp);
                                UnitSex.set(sortHelp,UnitSex.get(i));
                                UnitSex.set(i,localHelpSex);

                                localIntHelpAge = UnitAge.get(sortHelp);
                                UnitAge.set(sortHelp, UnitAge.get(i));
                                UnitAge.set(i, localIntHelpAge);

                                localIntHelpPoints = UnitPoints.get(sortHelp);
                                UnitPoints.set(sortHelp, UnitPoints.get(i));
                                UnitPoints.set(i, localIntHelpPoints);
                            }
                            System.out.println("Posortowano rosnąco.");
                            break;
                        case 2:
                            localHelpName="";
                            localHelpSurName="";
                            localHelpSex="";
                            localIntHelpAge=0;
                            localIntHelpPoints=-1;
                            sortHelp=0;
                            for(int i=0;i<counter;i++)
                            {
                                sortHelp=i;
                                for(int j=i+1;j<counter;j++)
                                {
                                    if(UnitSex.get(j).compareTo(UnitSex.get(sortHelp))<0)
                                        sortHelp=j;
                                }
                                localHelpName=UnitName.get(sortHelp);
                                UnitName.set(sortHelp,UnitName.get(i));
                                UnitName.set(i,localHelpName);

                                localHelpSurName=UnitSurName.get(sortHelp);
                                UnitSurName.set(sortHelp,UnitSurName.get(i));
                                UnitSurName.set(i,localHelpSurName);

                                localHelpSex=UnitSex.get(sortHelp);
                                UnitSex.set(sortHelp,UnitSex.get(i));
                                UnitSex.set(i,localHelpSex);

                                localIntHelpAge = UnitAge.get(sortHelp);
                                UnitAge.set(sortHelp, UnitAge.get(i));
                                UnitAge.set(i, localIntHelpAge);

                                localIntHelpPoints = UnitPoints.get(sortHelp);
                                UnitPoints.set(sortHelp, UnitPoints.get(i));
                                UnitPoints.set(i, localIntHelpPoints);
                            }
                            System.out.println("Posortowano Kobiety->Mezczysni.");
                            break;
                        case 3:
                            localHelpName="";
                            localHelpSurName="";
                            localHelpSex="";
                            localIntHelpAge=0;
                            localIntHelpPoints=-1;
                            sortHelp=0;
                            for(int i=0;i<counter;i++) {
                                sortHelp = i;
                                for (int j = i + 1; j < counter; j++) {
                                    if (UnitAge.get(j) < UnitAge.get(sortHelp))
                                        sortHelp = j;
                                }
                                localHelpName=UnitName.get(sortHelp);
                                UnitName.set(sortHelp,UnitName.get(i));
                                UnitName.set(i,localHelpName);

                                localHelpSurName=UnitSurName.get(sortHelp);
                                UnitSurName.set(sortHelp,UnitSurName.get(i));
                                UnitSurName.set(i,localHelpSurName);

                                localHelpSex=UnitSex.get(sortHelp);
                                UnitSex.set(sortHelp,UnitSex.get(i));
                                UnitSex.set(i,localHelpSex);

                                localIntHelpAge = UnitAge.get(sortHelp);
                                UnitAge.set(sortHelp, UnitAge.get(i));
                                UnitAge.set(i, localIntHelpAge);

                                localIntHelpPoints = UnitPoints.get(sortHelp);
                                UnitPoints.set(sortHelp, UnitPoints.get(i));
                                UnitPoints.set(i, localIntHelpPoints);
                            }
                            System.out.println("Posortowano rosnąco.");
                            break;
                        case 4:
                            localHelpName="";
                            localHelpSurName="";
                            localHelpSex="";
                            localIntHelpAge=0;
                            localIntHelpPoints=-1;
                            sortHelp=0;
                            for(int i=0;i<counter;i++) {
                                sortHelp = i;
                                for (int j = i + 1; j < counter; j++) {
                                    if (UnitPoints.get(j) < UnitPoints.get(sortHelp))
                                        sortHelp = j;
                                }
                                localHelpName=UnitName.get(sortHelp);
                                UnitName.set(sortHelp,UnitName.get(i));
                                UnitName.set(i,localHelpName);

                                localHelpSurName=UnitSurName.get(sortHelp);
                                UnitSurName.set(sortHelp,UnitSurName.get(i));
                                UnitSurName.set(i,localHelpSurName);

                                localHelpSex=UnitSex.get(sortHelp);
                                UnitSex.set(sortHelp,UnitSex.get(i));
                                UnitSex.set(i,localHelpSex);

                                localIntHelpAge = UnitAge.get(sortHelp);
                                UnitAge.set(sortHelp, UnitAge.get(i));
                                UnitAge.set(i, localIntHelpAge);

                                localIntHelpPoints = UnitPoints.get(sortHelp);
                                UnitPoints.set(sortHelp, UnitPoints.get(i));
                                UnitPoints.set(i, localIntHelpPoints);
                            }
                            System.out.println("Posortowano rosnąco.");
                            break;
                    }
                    break;
                case "4":
                    switch (x)
                    {
                        case 0:
                            localHelpName="";
                            localHelpSurName="";
                            localHelpSex="";
                            localIntHelpAge=0;
                            localIntHelpPoints=-1;
                            sortHelp=0;
                            for(int i=0;i<counter;i++)
                            {
                                sortHelp=i;
                                for(int j=i+1;j<counter;j++)
                                {
                                    if(UnitName.get(j).compareTo(UnitName.get(sortHelp))>0)
                                        sortHelp=j;
                                }
                                localHelpName=UnitName.get(sortHelp);
                                UnitName.set(sortHelp,UnitName.get(i));
                                UnitName.set(i,localHelpName);

                                localHelpSurName=UnitSurName.get(sortHelp);
                                UnitSurName.set(sortHelp,UnitSurName.get(i));
                                UnitSurName.set(i,localHelpSurName);

                                localHelpSex=UnitSex.get(sortHelp);
                                UnitSex.set(sortHelp,UnitSex.get(i));
                                UnitSex.set(i,localHelpSex);

                                localIntHelpAge = UnitAge.get(sortHelp);
                                UnitAge.set(sortHelp, UnitAge.get(i));
                                UnitAge.set(i, localIntHelpAge);

                                localIntHelpPoints = UnitPoints.get(sortHelp);
                                UnitPoints.set(sortHelp, UnitPoints.get(i));
                                UnitPoints.set(i, localIntHelpPoints);
                            }
                            System.out.println("Posortowano malejąco.");
                            break;
                        case 1:
                            localHelpName="";
                            localHelpSurName="";
                            localHelpSex="";
                            localIntHelpAge=0;
                            localIntHelpPoints=-1;
                            sortHelp=0;
                            for(int i=0;i<counter;i++)
                            {
                                sortHelp=i;
                                for(int j=i+1;j<counter;j++)
                                {
                                    if(UnitSurName.get(j).compareTo(UnitSurName.get(sortHelp))>0)
                                        sortHelp=j;
                                }
                                localHelpName=UnitName.get(sortHelp);
                                UnitName.set(sortHelp,UnitName.get(i));
                                UnitName.set(i,localHelpName);

                                localHelpSurName=UnitSurName.get(sortHelp);
                                UnitSurName.set(sortHelp,UnitSurName.get(i));
                                UnitSurName.set(i,localHelpSurName);

                                localHelpSex=UnitSex.get(sortHelp);
                                UnitSex.set(sortHelp,UnitSex.get(i));
                                UnitSex.set(i,localHelpSex);

                                localIntHelpAge = UnitAge.get(sortHelp);
                                UnitAge.set(sortHelp, UnitAge.get(i));
                                UnitAge.set(i, localIntHelpAge);

                                localIntHelpPoints = UnitPoints.get(sortHelp);
                                UnitPoints.set(sortHelp, UnitPoints.get(i));
                                UnitPoints.set(i, localIntHelpPoints);
                            }
                            System.out.println("Posortowano malejąco.");
                            break;
                        case 2:
                            localHelpName="";
                            localHelpSurName="";
                            localHelpSex="";
                            localIntHelpAge=0;
                            localIntHelpPoints=-1;
                            sortHelp=0;
                            for(int i=0;i<counter;i++)
                            {
                                sortHelp=i;
                                for(int j=i+1;j<counter;j++)
                                {
                                    if(UnitSex.get(j).compareTo(UnitSex.get(sortHelp))>0)
                                        sortHelp=j;
                                }
                                localHelpName=UnitName.get(sortHelp);
                                UnitName.set(sortHelp,UnitName.get(i));
                                UnitName.set(i,localHelpName);

                                localHelpSurName=UnitSurName.get(sortHelp);
                                UnitSurName.set(sortHelp,UnitSurName.get(i));
                                UnitSurName.set(i,localHelpSurName);

                                localHelpSex=UnitSex.get(sortHelp);
                                UnitSex.set(sortHelp,UnitSex.get(i));
                                UnitSex.set(i,localHelpSex);

                                localIntHelpAge = UnitAge.get(sortHelp);
                                UnitAge.set(sortHelp, UnitAge.get(i));
                                UnitAge.set(i, localIntHelpAge);

                                localIntHelpPoints = UnitPoints.get(sortHelp);
                                UnitPoints.set(sortHelp, UnitPoints.get(i));
                                UnitPoints.set(i, localIntHelpPoints);
                            }
                            System.out.println("Posortowano Mezczyzni->Kobiety.");
                            break;
                        case 3:
                            localHelpName="";
                            localHelpSurName="";
                            localHelpSex="";
                            localIntHelpAge=0;
                            localIntHelpPoints=-1;
                            sortHelp=0;
                            for(int i=0;i<counter;i++) {
                                sortHelp = i;
                                for (int j = i + 1; j < counter; j++) {
                                    if (UnitAge.get(j) > UnitAge.get(sortHelp))
                                        sortHelp = j;
                                }
                                localHelpName=UnitName.get(sortHelp);
                                UnitName.set(sortHelp,UnitName.get(i));
                                UnitName.set(i,localHelpName);

                                localHelpSurName=UnitSurName.get(sortHelp);
                                UnitSurName.set(sortHelp,UnitSurName.get(i));
                                UnitSurName.set(i,localHelpSurName);

                                localHelpSex=UnitSex.get(sortHelp);
                                UnitSex.set(sortHelp,UnitSex.get(i));
                                UnitSex.set(i,localHelpSex);

                                localIntHelpAge = UnitAge.get(sortHelp);
                                UnitAge.set(sortHelp, UnitAge.get(i));
                                UnitAge.set(i, localIntHelpAge);

                                localIntHelpPoints = UnitPoints.get(sortHelp);
                                UnitPoints.set(sortHelp, UnitPoints.get(i));
                                UnitPoints.set(i, localIntHelpPoints);
                            }
                            System.out.println("Posortowano malejąco.");
                            break;
                        case 4:
                            localHelpName="";
                            localHelpSurName="";
                            localHelpSex="";
                            localIntHelpAge=0;
                            localIntHelpPoints=-1;
                            sortHelp=0;
                            for(int i=0;i<counter;i++) {
                                sortHelp = i;
                                for (int j = i + 1; j < counter; j++) {
                                    if (UnitPoints.get(j) > UnitPoints.get(sortHelp))
                                        sortHelp = j;
                                }
                                localHelpName=UnitName.get(sortHelp);
                                UnitName.set(sortHelp,UnitName.get(i));
                                UnitName.set(i,localHelpName);

                                localHelpSurName=UnitSurName.get(sortHelp);
                                UnitSurName.set(sortHelp,UnitSurName.get(i));
                                UnitSurName.set(i,localHelpSurName);

                                localHelpSex=UnitSex.get(sortHelp);
                                UnitSex.set(sortHelp,UnitSex.get(i));
                                UnitSex.set(i,localHelpSex);

                                localIntHelpAge = UnitAge.get(sortHelp);
                                UnitAge.set(sortHelp, UnitAge.get(i));
                                UnitAge.set(i, localIntHelpAge);

                                localIntHelpPoints = UnitPoints.get(sortHelp);
                                UnitPoints.set(sortHelp, UnitPoints.get(i));
                                UnitPoints.set(i, localIntHelpPoints);
                            }
                            System.out.println("Posortowano malejąco.");
                            break;
                    }
                    break;
                case "5":
                    end=5;
                    break;
                default:
                    System.out.println("Błędny wybór.");
                    break;
            }
        }while(end!=5);
    }
}
