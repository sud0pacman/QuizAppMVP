package com.example.quizappmvp.domain;

import com.example.quizappmvp.data.model.CategoryEnum;
import com.example.quizappmvp.data.model.QuestionData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppController {
    private static AppController instance;
    private CategoryEnum selectCategory;
    private List<QuestionData> questions = new ArrayList<>();

    private AppController() {}

    public static AppController getInstance() {
        if (instance == null) {
            instance = new AppController();
        }

        return instance;
    }

    public void setSelectCategory(CategoryEnum category) {
        this.selectCategory = category;
        loadQuestion();
    }

    public CategoryEnum setSelectCategory() {
        return selectCategory;
    }

    public List<QuestionData> getQuestionByCategory() {
        Collections.shuffle(questions);
        return questions;
    }

    private void loadQuestion() {
        questions.clear();

        switch (selectCategory) {
            case GEOGRAFIYA: {
                questions.add(new QuestionData("Eng baland cho'qqi nomi ?", "Himolay", "Alp", "Everest", "Tibet", "Everest"));
                questions.add(new QuestionData("Eng katta okeam nomi ?", "Hind", "Atlantika", "Tinch", "Muz", "Tinch"));
                questions.add(new QuestionData("Piramidalar qayerda joylshgan ?", "Arabiston", "Liviya", "Misr", "Yaman", "Misr"));
                questions.add(new QuestionData("Kanada davlatining poytaxti ?", "Kanberra", "Ottava", "Jorjiya", "Los-Angles", "Ottava"));
                questions.add(new QuestionData("Janubiy Afrikaning sharqidagi orol nomini toping ?", "Gavaya", "Bora-bora", "Mauritius", "Madagaskar", "Madagaskar"));
                questions.add(new QuestionData("\"Geografiya” atamasining etimologik ma’nosi:", "yunoncha \"geo”-yer, \"grafio”-tasvirlayman", "lotincha \"geo”-yer, \"grafio”-chizaman", "arabcha \"geo”-yer, \"grafio”-tasvirlayman", "yunoncha \"geo”-yer, \"grafio”- o’qiyman", "yunoncha \"geo”-yer, \"grafio”-tasvirlayman"));
                questions.add(new QuestionData("Dastlabki xarita qachon tuzilgan?", "13 asr muqaddam", "14 asr muqaddam", "15 asr muqaddam", "16 asr muqaddam", "15 asr muqaddam"));
                questions.add(new QuestionData("\"Geografiya” atamasini birinchi bo’lib fanga kim kiritgan?", "Falas", "Pifagor", "Arastu", "Eratosfen", "Eratosfen"));
                questions.add(new QuestionData("Mariana botig'ining chuqurligi necha meter?", "1022M", "10022M", "10994M", "15200M", "10994M"));
                questions.add(new QuestionData("Buyuk  geografik  kashfiyotlar boshlangan asr  to’g’ri  yozilgan  javobni toping?", "XV asrning o’rtalaridan", "XV asrning  boshlaridan", "XV asrning  oxiridan", "XVI asrning  boshlaridan", "XV asrning o’rtalaridan"));
                break;
            }
            case TARIX: {
                questions.add(new QuestionData("Alisher Navoiy necahnchi yil tug'ilgan ?", "1501", "1441", "1482", "987", "1441"));
                questions.add(new QuestionData("Aljabr Val-Muqobala assari muallifi kim ?", "Abu Rayhon Beruniy", "Abu Ali Ibn-sino", "Al-Farg'oniy", "Al-Xorazmiy", "Al-Farg'oniy"));
                questions.add(new QuestionData("Jaloliddin Manguberdi Parvonjangida necha kishilik qo'shinga qarchi chiqqan ?", "45 ming", "42 ming", "54 ming", "80 ming", "45 ming"));
                questions.add(new QuestionData("Qadimgi Konstantinopol hozirgi davrdagi qaysi shahar ?", "Moskva", "Kiev", "Istanbul", "Qrim", "Istanbul"));
                questions.add(new QuestionData("Buxoro amiri bo'lgan Amir Nasrullo qaysi oilaning xonadonida tug'ilgan ?", "Amir Olim", "Amir Abbos", "Amir Haydar", "Amir Muhammad", "Amir Haydar"));
                questions.add(new QuestionData("\"Xalqlarning buyuk ko’chishlari\" jarayonini kimlar boshlab bergan ?", "Arablar", "Slavyanlar", "Germanlar", "Xunlar", "Xunlar"));
                questions.add(new QuestionData("Nechanchi asrda Xunnlarning Sharqdan hujumlari ko’payib varvar qabilalarini o’z makonlaridan siljishga majbur etadi?", "IV asrda", "I asrda", "III asrda", "II asrda", "IV asrda"));
                questions.add(new QuestionData("Qachon Xitoyda kitob bosish dastgohlari yaratilgan?", "IV asrda", "X asrda", "XI asrda", "XII asrda", "XI asrda"));
                questions.add(new QuestionData("O’rta asrlar tarixi necha yirik davrga bo’linadi?", "4", "5", "2", "3", "2"));
                questions.add(new QuestionData("O’rta asrlarning birinchi davri nechanchi asrlarni o’z ichiga oladi?", "V-XI asrlarni", "XI-XXV asrlarni", "XV-XVII asrlarni", "I-V asrlarni", "V-XI asrlarni"));
                break;
            }
            case FIZIKA: {
                questions.add(new QuestionData("Ish o'lchov birligi nima ?", "Daraja", "Pascal", "Joul", "Kelvin ", "Joul"));
                questions.add(new QuestionData("Bir modda molekulalarining ikkinchi modda molekulalariga ikkinchi modda molekulalarining birinchi modda molekulalariga o'zaro ta'siri fizikada nima deyialdi ?", "Fotosintez", "Diffuziya", "Birikish", "Tortilish", "Diffuziya"));
                questions.add(new QuestionData("Ochiq idishdagi suv uning tubidagi kichik teshikdan t vaqtda oqib chiqadi. Atmosfera bosimi kamaysa, suvning oqib chiqish vaqti qanday o‘zgaradi? ?", "kamayadi", "o‘zgarmaydi", "ortadi", "aniqlab bo'lmaydi", "kamayadi"));
                questions.add(new QuestionData("Massa 4kg va yuzasi 8m\u200B2 bo‘lgan gilam polga qancha bosim beradi (P a) ?", "0.5", "4.9", "2", "50", "4.9"));
                questions.add(new QuestionData("Porshenli nasos normal atmosfera bosimida suvni qanday balandlikka ko‘tarishi mumkin ?", "10", "7", "5", "6", "10"));
                questions.add(new QuestionData("Kristall qattiq jism eriyotganida uning harorati qanday o'zgaradi ?", "Kristall jism moddasiga bo'gliq", "o'zgarmaydi", "ortib boradi", "kamayib boradi", "o'zgarmaydi"));
                questions.add(new QuestionData("Molekula nimadan taskil topgan ?", "Atom", "Yadro", "Forton", "Neytron", "Atom"));
                questions.add(new QuestionData("Nyutonni nechta qonuni bor ?", "1", "2", "3", "4", "3"));
                questions.add(new QuestionData("Fazo va vaqtning har qanday fizik jarayon uchun o'rinli bo'lgan xususiyatlari haqidagi hozirgi zamon fizika taʼlimoti nima ?", "Modda nazariyasi", "Oqim nazariyasi", "Nisbiylik nazariyasi", "Gravitatsiya", "Nisbiylik nazariyasi"));
                questions.add(new QuestionData("Fizik jismlarning bir-biriga ularning massasiga mutanosib kuch bilan tortilishida nima namoyon bo'ladi ?", "Gravitatsiya", "Tortishish", "Itarish", "Tezlanish", "Gravitatsiya"));
                break;
            }
            case MATEMATIKA: {
                questions.add(new QuestionData("18 ni 3 dan 1 qismi nechaga teng ?", "4", "6", "9", "2 ", "6"));
                questions.add(new QuestionData("2 ning 9 darajasi necha ?", "1024", "256", "512", "128", "512"));
                questions.add(new QuestionData("81 ning tup ildizi nechaga teng? ?", "8", "9", "17", "12", "9"));
                questions.add(new QuestionData("1 tonna necha sentner ?", "10", "100", "110", "0.10", "100"));
                questions.add(new QuestionData("Kvadrat tenglamani topishga yordam beruvchi formula nomi nima ?", "Foydalanish formulas", "Diskriminant", "Tanlash usuli", "Daraja formulasi", "Diskriminant"));
                questions.add(new QuestionData("To'g'ri to'rtburchakning perimetri qanday hisoblanadi ?", "Barcha tomonlar yig'indisi", "Ikki tomon uzunligi yig'indisi", "Ikki tomon uzunligi va ikki tomon qisqarishi yig'indisi", "Burchaklar yig'indisi", "Barcha tomonlar yig'indisi"));
                questions.add(new QuestionData("1 kilogram necha grammga teng ?", "100", "1000", "10", "10 000", "1000"));
                questions.add(new QuestionData("2 ning 5-darajasi nechaga teng ?", "8", "16", "32", "64", "32"));
                questions.add(new QuestionData("4x + 3 = 19 tenglama uchun x ni toping.", "4", "5", "6", "7", "4"));
                questions.add(new QuestionData("200 ning 20% nechaga teng ?", "10", "20", "30", "40", "40"));
                break;
            }
            case DASTURLASH: {
                questions.add(new QuestionData("Java dasturlash tili asoschisi kim ?", "Guvido Van Rossum", "James Gosling", "Graydon Hoare", "Bjarne Stroustrup ", "James Gosling"));
                questions.add(new QuestionData("Windows OT larda oxirgi amalni bekor qiluvchi qisqa tugma ?", "ctrl + l", "ctrl + shift + n", "ctrl + z", "ctrl + x", "ctrl + z"));
                questions.add(new QuestionData("Dasturlashda o'zini qiymatini va o'zidan keyingi element manzilini saqlovchi ma'lumot turi nomi: ", "Array list", "Massiv", "Map", "Linked list", "Linked list"));
                questions.add(new QuestionData("Bir obyektdan boshqa obyekt nusxs olinsa va ularning biri o'zgartirilsa ikkalasi ham o'zgarsa bu qanday nusxa olishga kiradi: ", "Deep", "Shallow", "Temp", "Simple", "Shallow"));
                questions.add(new QuestionData("Java dasturlash tilida nechta primitive toifa bor: ", "6", "7", "8", "9", "8"));
                questions.add(new QuestionData("Java dasturlash tilida char toifasi xotiradan necha byte joy oladi ?", "1 byte", "2 byte", "4 byte", "8 byte", "2 byte"));
                questions.add(new QuestionData("Java dasturlash tilida primitive toifalar xotiraning qaysi qismidan joy oladi ?", "Heap", "Stack", "Metaspace", "Permgen", "Stack"));
                questions.add(new QuestionData("Procedual dasturlash tilini toping ?", "Pascal", "Scala", "Java", "PHP", "Pascal"));
                questions.add(new QuestionData("Kotlin dasturlash tilida 3ta teng nimani tekshiradi ?", "Qiymatni", "Reference ni", "Raqamlarni", "Stringlarni", "Reference ni"));
                questions.add(new QuestionData("Bu yerda qaysi biri framework emas", "Kotlin", "Flask", "Python", "Django", "Python"));
            }
        }
    }
}

























