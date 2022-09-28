import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Redactor> editors = new ArrayList<Redactor>();

    public static void main(String[] args) {
        int option = 0;
        String ans = "";

        do {
            System.out.println("Choose an option: \n"
                    + "1.Enter editor \n"
                    + "2.Delete editor \n"
                    + "3.Enter a new article for editor \n"
                    + "4.Delete an article(editor/title)\n"
                    + "5.Show articles(editor)\n"
                    + "6.Calculate punts of an arcticle\n"
                    + "7.Calculate price of an article\n"
                    + "0.Exit");
            option = scan.nextInt();


            switch (option) {
                case 1:
                    ans = enterEditor();
                    break;
                case 2:
                    ans = deleteEditor();
                    break;
                case 3:
                    ans = enterArticle();
                    break;
                case 4:
                    ans = deleteArticle();
                    break;
                case 5:
                    ans = showArticle();
                    break;
                case 6:
                    ans = calculatePunts();
                    break;
                case 7:
                    ans = calculatePrice();
                    break;
            }
            System.out.println(ans);
        } while (option != 0);

    }

    public static String enterEditor() {
        Redactor editor = new Redactor();
        //To control the editor with the same name
        boolean editorNotFound = false;
        do {
            String editorName = "";
            System.out.println("Enter the name of the editor");
            editorName = scan.nextLine();
            scan.nextLine();
            if(editors.size()>0){
                boolean nameFound = false;
                for(int i = 0;i < editors.size() && nameFound == false; i++){
                    Redactor editorFound = editors.get(i);
                    if(editorName.equalsIgnoreCase(editorFound.getNom())){
                        System.out.println("There is already an editor with the same name");
                        nameFound = true;
                    }else{
                        editorNotFound = true;
                        editor.setNom(editorName);
                    }
                }
            }else {
                editor.setNom(editorName);
                editorNotFound = true;
            }
        }while(!editorNotFound);
        //To check if there is some editor with the same id
        boolean IDNotFound = false;
        do{
            String id = "";
            System.out.println("Enter the ID");
            id = scan.next();
            if(editors.size()>0){
                boolean IDFound = false;
                for(int i = 0;i < editors.size() && IDFound == false; i++){
                    Redactor editorFound = editors.get(i);
                    if(id.equalsIgnoreCase(editorFound.getDNI())){
                        System.out.println("Check the ID. There is another editor with the same ID");
                        IDFound = true;
                    }else{
                        IDNotFound = true;
                        editor.setDNI(id);
                    }
                }
            }else{
                IDNotFound = true;
                editor.setDNI(id);
            }
        }while(!IDNotFound);
        editors.add(editor);
        return "The new editor " + editor.getNom() + " was saved successfully.";
    }

    public static int searchEditor() {
        int index = 0;
        boolean nameFound = false;
        String nomDel = "";
        System.out.println("Enter the name of the editor you'are searching for");
        nomDel = scan.nextLine();
        scan.nextLine();
        for (int i = 0; i < editors.size() && nameFound == false; i++) {
            Redactor editorFound = editors.get(i);
            if (editorFound.getNom().equalsIgnoreCase(nomDel)) {
                index = i;
                nameFound = true;
            } else {
                index = -1;
            }
        }

        return index;
    }

    public static String deleteEditor() {
        String ans = "";
        String nomDel = "";
        int index = 0;
        if (editors.size() > 0) {
            index = searchEditor();
            if (index == -1) {
                ans = "Editor not found";
            } else {
                ans = "The editor " + editors.get(index).getNom() + " was deleted successfully";
                editors.remove(index);
            }
        } else {
            ans = "There is any saved editor";
        }
        return ans;
    }

    public static String enterArticle() {
        String ans = "";
        int option = 0;
        if (editors.size() > 0) {
            System.out.println("What kind of sport is it?\n"
                    + "1. Football\n"
                    + "2. Basketball\n"
                    + "3. Tennir\n"
                    + "4. F1\n"
                    + "5. Moto");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    ans = enterFootball();
                    break;
                case 2:
                    ans = enterBasketball();
                    break;
                case 3:
                    ans = enterTennis();
                    break;
                case 4:
                    ans = enterF1();
                    break;
                case 5:
                    ans = enterMoto();
                    break;
            }
        } else {
            ans = "To create an article, first you need to add an editor";
        }
        return ans;
    }

    public static String enterFootball() {
        String ans = "";
        int index = 0;
        index = searchEditor();
        scan.nextLine();
        if (index == -1) {
            ans = "Editor not found";
        } else {
            Futbol football = new Futbol();
            //To control the article with the same title
            boolean titleNotFound = false;
            do {
                String footballTitle = "";
                System.out.println("Enter the title");
                footballTitle = scan.nextLine();
                scan.nextLine();
                if (editors.get(index).getNoticia().size() > 0) {
                    boolean titleFound = false;
                    for (int i = 0; i < editors.get(index).getNoticia().size() && titleFound == false; i++) {
                        Noticia footballFound = editors.get(index).getNoticia().get(i);
                        if (footballTitle.equalsIgnoreCase(footballFound.getTitular())) {
                            System.out.println("This editor already has the article with the same title.");
                            titleFound = true;
                        } else {
                            titleNotFound = true;
                            football.setTitular(footballTitle);
                        }
                    }
                } else {
                    titleNotFound = true;
                    football.setTitular(footballTitle);
                }
            }while(!titleNotFound);
                football.setPreu(300);
                football.setPuntuacio(5);
                System.out.println("Enter the club's name");
                football.setClub(scan.next());
                System.out.println("Enter the competition");
                football.setCompeticio(scan.next());
                System.out.println("Is it the LLiga Champions?");
                String isChampions = "";
                isChampions = scan.next();
                if (isChampions.equalsIgnoreCase("yes")) {
                    football.setLligaChampions(true);
                }
                scan.nextLine();
                System.out.println("Enter the football player");
                football.setJugador(scan.nextLine());
                editors.get(index).setNoticia(football);
                ans = "This article was created successfully";
            }

        return ans;
    }

    public static String enterBasketball() {
        String ans = "";
        int index = 0;
        index = searchEditor();
        scan.nextLine();
        if (index == -1) {
            ans = "Editor not found";
        } else {
            Basquet basketball = new Basquet();
            boolean titleNotFound = false;
            do {
                String basketballTitle = "";
                System.out.println("Enter the title");
                basketballTitle = scan.nextLine();
                scan.nextLine();
                if (editors.get(index).getNoticia().size() > 0) {
                    boolean titleFound = false;
                    for (int i = 0; i < editors.get(index).getNoticia().size() && titleFound == false; i++) {
                        Noticia basketballFound = editors.get(index).getNoticia().get(i);
                        if (basketballTitle.equalsIgnoreCase(basketballFound.getTitular())) {
                            System.out.println("This editor already has the article with the same title.");
                            titleFound = true;
                        } else {
                            titleNotFound = true;
                            basketball.setTitular(basketballTitle);
                        }
                    }
                } else {
                    titleNotFound = true;
                    basketball.setTitular(basketballTitle);
                }
            }while(titleNotFound!=true);
            basketball.setPreu(250);
            basketball.setPuntuacio(4);
            System.out.println("Enter the club's name");
            basketball.setClub(scan.next());
            System.out.println("Enter the competition");
            basketball.setCompeticio(scan.next());
            System.out.println("Is it Eurolliga?");
            String isEurolliga = "";
            isEurolliga = scan.next();
            if (isEurolliga.equalsIgnoreCase("yes")) {
                basketball.setEurolliga(true);

            }
            editors.get(index).setNoticia(basketball);
            ans = "This article was created successfully";
        }
        return ans;
    }

    public static String enterTennis() {
        String ans = "";
        int index = 0;
        index = searchEditor();
        scan.nextLine();
        if (index == -1) {
            ans = "Editor not found";
        } else {
            Tenis tennis = new Tenis();
            boolean titleNotFound = false;
            do {
                String tennisTitle = "";
                System.out.println("Enter the title");
                tennisTitle = scan.nextLine();
                scan.nextLine();
                if (editors.get(index).getNoticia().size() > 0) {
                    boolean titleFound = false;
                    for (int i = 0; i < editors.get(index).getNoticia().size() && titleFound == false; i++) {
                        Noticia tennisFound = editors.get(index).getNoticia().get(i);
                        if (tennisTitle.equalsIgnoreCase(tennisFound.getTitular())) {
                            System.out.println("This editor already has the article with the same title.");
                            titleFound = true;
                        } else {
                            titleNotFound = true;
                            tennis.setTitular(tennisTitle);
                        }
                    }
                } else {
                    titleNotFound = true;
                    tennis.setTitular(tennisTitle);
                }
            }while(titleNotFound!=true);
            tennis.setPreu(150);
            tennis.setPuntuacio(4);
            System.out.println("Enter the competition");
            tennis.setCompeticio(scan.next());
            System.out.println("Enter the 1st player");
            tennis.setJugador1(scan.next());
            System.out.println("Enter the 2nd player");
            tennis.setJugador2(scan.next());
            editors.get(index).setNoticia(tennis);
            ans = "This article was created successfully";
        }
        return ans;
    }

    public static String enterF1() {
        String ans = "";
        int index = 0;
        index = searchEditor();
        scan.nextLine();
        if (index == -1) {
            ans = "Editor not found";
        } else {
            F1 f1 = new F1();
            boolean titleNotFound = false;
            do {
                String f1Title = "";
                System.out.println("Enter the title");
                f1Title = scan.nextLine();
                scan.nextLine();
                if (editors.get(index).getNoticia().size() > 0) {
                    boolean titleFound = false;
                    for (int i = 0; i < editors.get(index).getNoticia().size() && titleFound == false; i++) {
                        Noticia f1Found = editors.get(index).getNoticia().get(i);
                        if (f1Title.equalsIgnoreCase(f1Found.getTitular())) {
                            System.out.println("This editor already has the article with the same title.");
                            titleFound = true;
                        } else {
                            titleNotFound = true;
                            f1.setTitular(f1Title);
                        }
                    }
                } else {
                    titleNotFound = true;
                    f1.setTitular(f1Title);
                }
            }while(titleNotFound!=true);
            f1.setPreu(100);
            f1.setPuntuacio(4);
            System.out.println("Enter the team");
            f1.setEscuderia(scan.next());
            editors.get(index).setNoticia(f1);
            ans = "This article was created successfully";
        }
        return ans;
    }

    public static String enterMoto() {
        String ans = "";
        int index = 0;
        index = searchEditor();
        scan.nextLine();
        if (index == -1) {
            ans = "Editor not found";
        } else {
            Motociclisme moto = new Motociclisme();
            boolean titleNotFound = false;
            do {
                String motoTitle = "";
                System.out.println("Enter the title");
                motoTitle = scan.nextLine();
                scan.nextLine();
                if (editors.get(index).getNoticia().size() > 0) {
                    boolean titleFound = false;
                    for (int i = 0; i < editors.get(index).getNoticia().size() && titleFound == false; i++) {
                        Noticia footballFound = editors.get(index).getNoticia().get(i);
                        if (motoTitle.equalsIgnoreCase(footballFound.getTitular())) {
                            System.out.println("This editor already has the article with the same title.");
                            titleFound = true;
                        } else {
                            titleNotFound = true;
                            moto.setTitular(motoTitle);
                        }
                    }
                } else {
                    titleNotFound = true;
                    moto.setTitular(motoTitle);
                }
            }while(titleNotFound!=true);
            moto.setPreu(100);
            moto.setPuntuacio(3);
            System.out.println("Enter the team");
            moto.setEquip(scan.next());
            editors.get(index).setNoticia(moto);
            ans = "This article was created successfully";

        }
        return ans;
    }


    public static String deleteArticle() {
        String ans = "";
        if (editors.size() > 0) {
                int indexR = 0;
                indexR = searchEditor();
                scan.nextLine();
                if (indexR == -1) {
                    ans = "Editor not found";
                } else {
                    if (editors.get(indexR).getNoticia().size() > 0) {
                        String title = "";
                        boolean titleFound = false;
                        System.out.println("Enter the title you're looking for");
                        title = scan.nextLine();
                        scan.nextLine();
                        for (int i = 0; i < editors.get(indexR).getNoticia().size() && titleFound == false; i++) {
                            Noticia news = editors.get(indexR).noticias.get(i);
                            if (title.equalsIgnoreCase(editors.get(indexR).noticias.get(i).getTitular())) {
                                int indexNews = i;
                                titleFound = true;
                                editors.remove(editors.get(indexR).noticias.remove(i));
                                ans = "This article was deleted successfully";
                            } else {
                                ans = "This editor doesn't have any article with this title";
                            }
                        }
                    } else {
                        ans = "This editor doesn't have any article";
                    }
                }
        }else{
            ans = "There is any saved editor";
        }
        return ans;
    }

    public static String showArticle() {
        String ans = "";
        if(editors.size()>0) {
                int index = 0;
                index = searchEditor();
                if (index == -1) {
                    ans = "Editor not found";
                } else {
                    if (editors.get(index).getNoticia().size() > 0) {
                        editors.get(index).getNoticia().forEach((Noticia c) -> System.out.println("Article:" + c.getTitular()));

                    } else {
                        ans = "This editor doesn't have any article";
                    }
                }
        }else{
            ans = "There is any saved editor";
        }


        return ans;
    }

    public static int searchArticle() {
        int index = 0;
        String titleNews = "";
        boolean titleFound = false;
        System.out.println("Enter the title of the article you're looking for");
        titleNews = scan.nextLine();
        for (int i = 0; i < editors.size() && titleFound == false; i++) {
            for (int j = 0; j < editors.get(i).getNoticia().size() && titleFound == false; j++){
                Noticia articleFound = editors.get(i).getNoticia().get(j);
                if (titleNews.equalsIgnoreCase(articleFound.getTitular())) {
                    index = j;
                    titleFound = true;
                } else {
                    index = -1;
                }
            }
        }
        return index;
    }

    public static String calculatePunts() {
        String ans = "";
        if(editors.size()>0) {
                int indexR = 0;
                indexR = searchEditor();
                scan.nextLine();
                if (indexR == -1) {
                    ans = "Editor not found";
                } else {
                    if(editors.get(indexR).getNoticia().size()>0){
                        int indexN  = 0;
                        int punts = 0;
                        indexN = searchArticle();
                        scan.nextLine();
                        if(indexN == -1){
                            ans = "This editor doesn't have any article with this name";
                        }else {
                            Noticia articleFound = editors.get(indexR).getNoticia().get(indexN);
                            punts = articleFound.calcularPuntuacio();
                            ans = "This article has " + punts + " punts";
                        }
                    }else{
                        ans = "This editor doesn't have any article";
                        }
                    }

        }else{
            ans = "There is any saved editor";
        }
        return ans;
    }
    public static String calculatePrice() {
        String ans = "";
        if (editors.size() > 0) {
                int indexR = 0;
                indexR = searchEditor();
                scan.nextLine();
                if(indexR == -1){
                    ans = "Editor not found";
                }else {
                    if(editors.get(indexR).getNoticia().size()>0){
                        int priceTotal = 0;
                        int indexN = 0;
                        indexN = searchArticle();
                        scan.nextLine();
                        if (indexN == -1) {
                            ans = "This editor doesn't have any article with this name";
                        } else {
                            Noticia artcileFound = editors.get(indexR).getNoticia().get(indexN);
                            priceTotal = artcileFound.calcularPreu();
                            ans = "The price of this article is " + priceTotal + ". ";
                        }
                    }else{
                        ans = "This editor doesn't have any article";
                    }

                }
        }else{
            ans = "There is any saved editor";
        }
        return ans;
}
}
