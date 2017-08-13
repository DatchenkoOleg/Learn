package com.datchenko;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map
/*Просмотр конфликлов git, изменения в ветке m*/


/*Просмотр конфликлов git, изменения в ветке master*/


public class Phonebook {
    private static Map<String, ArrayList<String>> personPhone = new HashMap<>();

    static {
        rewritePhonebook(10);
        personPhone.put("Петров Дмитрий Борисович", randPhone());
    }

    public static void main(String[] args) {
        for (String element : args) {
            System.out.println(new Phonebook().searchPerson(element));
        }
    }

    public static void rewritePhonebook(int sizePhonebook) {
        String temp;
        personPhone.clear();
        for (int i = 0; i < 10; ) {
            temp = randFnLn();
            if (personPhone.get(temp) == null) {
                personPhone.put(temp, randPhone());
                i++;
            }
        }
    }

    private static ArrayList<String> randPhone() {
        ArrayList<String> listPhone = new ArrayList<>();
        StringBuilder tempEndPhone = new StringBuilder();
        int amtPhoneClient = (int) (Math.random() * 4 + 1);
        for (int i = 0; i < amtPhoneClient; i++) {
            for (int j = 0; j < 11; j++) {
                tempEndPhone.append((int) (Math.random() * 10));
            }
            listPhone.add("+" + tempEndPhone);
            tempEndPhone.delete(0, tempEndPhone.length());
        }
        return listPhone;
    }

    private static String randFnLn() {
        StringBuilder snFn = new StringBuilder();
        String[] surname = new String[]{"Смирнов", "Иванов", "Кузнецов", "Попов", "Соколов", "Лебедев", "Козлов", "Новиков", "Морозов", "Петров"};
        String[] filename = new String[]{"Александр", "Денис", "Сергей", "Андрей", "Дмитрий", "Антон", "Кирилл", "Владислав", "Валерий", "Евгений"};
        String[] patronymic = new String[]{"Александрович", "Алексеевич", "Анатольевич", "Андреевич", "Антонович", "Аркадьевич", "Артемович", "Бедросович", "Богданович", "Борисович"};
        snFn.append(surname[(int) (Math.random() * 10)]).append(" ").append(filename[(int) (Math.random() * 10)]).append(" ").append(patronymic[(int) (Math.random() * 10)]);
        return snFn.toString();
    }

    public String searchPerson(String key) {
        StringBuilder strSearchPerson = new StringBuilder(key);
        ArrayList<String> searhPhone = personPhone.get(key);
        int i = 1;
        try {
            for (String element : searhPhone) {
                strSearchPerson.append("\n").append(i).append(". ").append(element);
                i++;
            }
        } catch (NullPointerException e) {
            strSearchPerson.append(" отсутсвует в справочнике.");
            return strSearchPerson.toString();
        }
        return strSearchPerson.toString();
    }

    @Override
    public String toString() {
        StringBuilder printPersonPhone = new StringBuilder();
        for (Map.Entry<String, ArrayList<String>> entry : personPhone.entrySet()) {
            printPersonPhone.append(entry.getKey()).append(":\n");
            for (String element : entry.getValue()) {
                printPersonPhone.append(element).append("\n");
            }
        }
        return printPersonPhone.toString();

    }

}