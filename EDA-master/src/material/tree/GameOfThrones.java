package material.tree;

import material.tree.iterator.PreorderIteratorFactory;

import java.io.*;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by David R on 06/06/2016.
 */
public class GameOfThrones {

    private static List<LinkedTree<FamilyMember>> WesterosListOfTrees = new ArrayList<>(); //array de ARBOLES de las familias
    private static ArrayList<FamilyMember> peopleList = new ArrayList<>();//arrayList de todos los familiares, personas


    private class FamilyMember {
        private String id;
        private String name;
        private String surname;
        private String gender;
        private int age;


        public FamilyMember(String id, String name, String surname, String gender, int age) {
            this.id = id;
            this.surname = surname;
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public FamilyMember() {
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }



    public void loadFile(String pathToFile) throws FileNotFoundException, IOException {

        File file = new File(pathToFile); //Archivo
        Scanner sc = new Scanner(file);

        FamilyMember newPerson;//para añadir nuevas personas
        //ArrayList<FamilyMember> peopleList = new ArrayList<>();//arrayList de todos los familiares, personas
        ArrayList<String> familyHeadsList = new ArrayList<>();//ArrayList con los codigos de los cabeza de familia
        ArrayList<String> relationsList = new ArrayList<>(); //ArrayList con las relacionse Padre->hijo
        Integer numHeads = 0;

        while(sc.hasNext()) { // Probar con a ver sc.hasNextLine()

            LinkedTree<FamilyMember> treeHeads = new LinkedTree<>(); //arbol nuevo que se metera en el array listaRaices


            String linea = sc.nextLine(); //guarda en linea la linea que se lee en cada momento
            String[] lineaDividida = linea.split(" "); //crea un array con las pabras de la linea anterior, porque hacemos splite con espacios

            if (linea.contains(" = ")){

                String id = lineaDividida[0];
                //System.out.println("id: "+ id);
                String name = lineaDividida[2];
                //System.out.println("name: "+ name);
                String surname = lineaDividida[3];
                //System.out.println("surname: "+ surname);
                String gender = lineaDividida[4];
                //System.out.println("gender: "+ gender);
                Integer age = Integer.valueOf(lineaDividida[5]);
                //System.out.println("age: "+ age);

                newPerson  = new FamilyMember(id,name,surname,gender, age);
                peopleList.add(newPerson);

            }
            else if (linea.contains("----")){
                String LineaNumFamilias = sc.nextLine();
                //System.out.println("------------------------------");
                //System.out.println("num Familias: "+LineaNumFamilias);
                numHeads = Integer.valueOf(LineaNumFamilias);
                //System.out.println("num Familias: "+numHeads);
            }
            else if(lineaDividida.length == 1){
                String idHead = lineaDividida[0];
                familyHeadsList.add(idHead);

                //System.out.println("Cabeza de familia: "+idHead);
            }
            else if (lineaDividida.length == 3){

                String lineaRelacion = linea;
                relationsList.add(lineaRelacion);

                String padre = lineaDividida[0];
                String hijo = lineaDividida[2];

                //System.out.println("LineaRelacion: " +lineaRelacion);
                //System.out.println("Padre: " +padre);
                //System.out.println("Hijo: " +hijo);
            }
        }
        sc.close();

        //tenemos una lista con todas las personas, un numero de cabezas, una lista de cabezas y una lista de relaciones.
        //System.out.println(numHeads);
        //metemos en la lista de arboles, los arboles de cada familia solo con la raiz
        for (int i=0; i<numHeads; i++ ){

            String headId = familyHeadsList.get(i);//sacamos los id de los cabeza de familia
            LinkedTree<FamilyMember> HouseFamilyTree = new LinkedTree<>(); //arbol de cada familia
            //System.out.println("Cabeza actual : " + headId);

            FamilyMember HouseRoot = getPersonById(peopleList, headId);//obtenemos el miembro dado por e id, en este caso la raiz
            HouseFamilyTree.addRoot(HouseRoot); //añadida raiz al arbol de la familia, el cabeza de familia,

            //en cada ciclo añadimos un arbol de cada familia con raiz
            WesterosListOfTrees.add(i,HouseFamilyTree); // Metemos en la posicion i, el arbol con su raiz
        }

        for (String rel :relationsList){ //para cada arbol miramos en toda la lista de relaciones
            String[] relSplited = rel.split(" ");
            String idParent = relSplited[0] ;
            String idChild = relSplited[2];

            FamilyMember parent = getPersonById(peopleList,idParent);
            FamilyMember child = getPersonById(peopleList,idChild);
            for(LinkedTree<FamilyMember> FamilyTree :WesterosListOfTrees){
                /*Como solo hemos añadido las raices a cada arbol solo
                encontrará relaciones que vengan directamente del cabeza de familia*/
                Position<FamilyMember> elemParent = belongsToTree(FamilyTree,idParent );//comprobamos si el 'padre' de la relacion esta en el arbol
                if(elemParent != null){
                    FamilyTree.add(getPersonById(peopleList,idChild), elemParent); //Añadimos el 'hijo'  de la relacion al arbol
                }
            }
        }

        //System.out.println(" ........");
        //System.out.println("Longitud de la lista de cabezas: "+familyHeadsList.size());
        //System.out.println("Cantidad de gente: "+peopleList.size());

    }

    public Position<FamilyMember> belongsToTree (LinkedTree<FamilyMember> arbol, String id ){

        Iterator<Position<FamilyMember>> it = arbol.iterator();
        Position<FamilyMember> pos ; //position
        FamilyMember member; // persona en el position

        while (it.hasNext()){
            pos = it.next();
            member = pos.getElement();
            if(member.getId().equals(id)){
                return pos;
            }
        }
        return null;
    }


    public FamilyMember getPersonById (ArrayList<FamilyMember> arrayDePersonas, String id) {

        for ( FamilyMember member: arrayDePersonas){
            if (member.getId().equals(id)){
                return member;
            }
        }
        return null;
    }
    public FamilyMember getPersonByName (String name) {

        for ( FamilyMember member: peopleList){
            if (member.getName().equals(name)){
                return member;
            }
        }
        return null;
    }

    public void printTreeElements (LinkedTree<FamilyMember> tree) throws NoSuchFieldException{
        if (tree!= null){
            System.out.println("Arbol de la casa "+tree.root().getElement().getSurname());

            Iterator<Position<FamilyMember>> it = tree.iterator();
            Position <FamilyMember> depthAnalizer = null;
            while (it.hasNext()){
                Position<FamilyMember> nodo = it.next();
                String name = nodo.getElement().getName();
                String surname = nodo.getElement().getSurname();
                System.out.println(name+" "+surname);
            }
        }
        else{
            throw new NoSuchFieldException("El arlbol introducido no es valido");
        }
    }

    public void printLinkedTree(LinkedTree<FamilyMember> family){
        System.out.println( family.root().getElement().getSurname() + "'s Tree");
        System.out.println();
        family.setIterator(new PreorderIteratorFactory<>());
//        Iterator<Position<FamilyMember>> it = new PreorderIteratorFactory<FamilyMember>().createIterator(family);
        Iterator<Position<FamilyMember>> it = family.iterator();
        Position <FamilyMember> pos = null;
        while(it.hasNext()){
            Position<FamilyMember> member = it.next();
            pos = member;
            while (pos != family.root()){
                pos = family.parent(pos);
                System.out.print("  |  ");

            }

            System.out.println("  |- " + member.getElement().getName() + " " + member.getElement().getSurname());

        }
        System.out.println();
    }

    public LinkedTree<FamilyMember> getFamily(String surname) throws IllegalStateException{

        LinkedTree<FamilyMember> tree = null;

        for (LinkedTree<FamilyMember> familyTree : WesterosListOfTrees){

            if (familyTree.root().getElement().getSurname().equals(surname)){
                tree = familyTree;
                return tree;
            }
        }
        throw new IllegalStateException("Incorrect family name");

    }


    public String findHeir(String surname){
        LinkedTree<FamilyMember> familyTree = getFamily(surname);
        Position<FamilyMember> root = familyTree.root();
        Position<FamilyMember> solutionHeir = null;
        for (Position<FamilyMember> member : familyTree.children(root)){
            if(member.getElement().gender.equals("(M)")){
                if(solutionHeir == null){
                    solutionHeir = member;
                }
                else if (solutionHeir.getElement().gender.equals("(F)") || solutionHeir.getElement().getAge() < member.getElement().getAge()){
                    solutionHeir = member;
                }
            }
            else if(member.getElement().gender.equals("(F)")){
                if(solutionHeir == null){
                    solutionHeir = member;
                }
                else if (solutionHeir.getElement().gender.equals("(F)") && solutionHeir.getElement().getAge() < member.getElement().getAge()){
                    solutionHeir = member;
                }
            }
        }
        return solutionHeir.getElement().getName();
    }


    public static void changeFamily(String nameToMove, String newParent) {
        //sacamos los arboles en los que se encuentran el nodo a mover y su futuro padre
        LinkedTree<FamilyMember> treeNameToMove = getFamilyByName(nameToMove);
        LinkedTree<FamilyMember> treeParent = getFamilyByName(newParent);
        //
        Position<FamilyMember> posNameToMove = getPositionByName(treeNameToMove, nameToMove);
        Position<FamilyMember> posNewParent = getPositionByName(treeParent, newParent);

        treeNameToMove.moveSubtree(posNameToMove, posNewParent);
    }

    private static Position<FamilyMember> getPositionByName(LinkedTree<FamilyMember> tree, String name)throws IllegalStateException{
        Iterator<Position<FamilyMember>> it = tree.iterator();
        while(it.hasNext()){
            Position<FamilyMember> pos = it.next();
            if(pos.getElement().getName().equals(name)){
                return pos;
            }
        }
        throw new IllegalStateException ("Nombre invalido.");

    }
    private static LinkedTree<FamilyMember> getFamilyByName(String name) throws IllegalStateException{
        for (LinkedTree<FamilyMember> family : WesterosListOfTrees) {
            Iterator<Position<FamilyMember>> it = family.iterator();
            while (it.hasNext()) {
                if (it.next().getElement().getName().equals(name)) {

                    return family;

                }
            }
        }
        throw new IllegalStateException("Invalid Name");
    }


    public boolean areFamily(String name1, String name2){
        LinkedTree<FamilyMember> treeName1 = getFamilyByName(name1);
        LinkedTree<FamilyMember> treeName2 = getFamilyByName(name2);

        if (treeName1.root().getElement().getSurname().equals(treeName2.root().getElement().getSurname())){

            return true;
        }
        else {
            return false;
        }

    }
    public static void main(String[] args) throws IOException, NoSuchFieldException {



        GameOfThrones got = new GameOfThrones();
        got.loadFile("C:\\Users\\David R\\IdeaProjects\\EDA\\src\\got_edited.txt");
        //got.printTreeElements(WesterosListOfTrees.get(0));
        //got.printTreeElements(got.getFamily("Targaryen"));
        //System.out.println(got.findHeir("Lannister"));

        //got.getFamilyByName("Aegon");
        /*got.printLinkedTree(got.getFamily("Targaryen"));
        got.changeFamily("Aegon","Rhaegar");
        //got.printTreeElements(got.getFamily("Targaryen"));
        got.printLinkedTree(got.getFamily("Targaryen"));
        */
        //System.out.println("Familia? "+got.areFamily("Aegon","Rhaegar"));
        //-------------------------------------------------------



        Scanner teclado = new Scanner(System.in);
        String opcion = "";
        //opcion =teclado.nextLine();

        while (!opcion.equals("5")) {
            System.out.println(" ---------------------------------------------- ");
            System.out.println("|               Game Of Thrones:               |");
            System.out.println("|                   The App                    |");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("1 -> Consultar integrantes de una familia.");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("2 -> Consultar heredero de una familia.");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("3 -> Cambiar de familia.");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("4 -> Consultar parentesco.");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("5 -> Salir del programa.");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("\n");
            System.out.println("Selecciona una opcion.\n");
            opcion =teclado.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Consultar integrantes de una familia");
                    System.out.println("Introduzca un apellido para obtener el arbol de los integrantes de la familia");
                    System.out.println("Las opciones son: Stark, Tully, Lannister, Baratheon, Targaryen o Greyjoy");
                    try{
                        String surname = teclado.nextLine();
                        LinkedTree<FamilyMember> family = got.getFamily(surname);
                        got.printLinkedTree(family);
                    }
                    catch (Exception e){
                        System.out.println("La familia introdicida no es valida");
                    }


                    System.out.println("");


                    break;
                case "2":
                    System.out.println("Consultar heredero de una familia.");
                    System.out.println("Introduzca una de las casas para saber el nombre de su heredero");
                    System.out.println("Las opciones son: Stark, Tully, Lannister, Baratheon, Targaryen o Greyjoy");

                    try{
                        String Family = teclado.nextLine();
                        String heir = got.findHeir(Family);
                        System.out.println("El heredero de la casa "+Family+" es: "+ heir);
                    }
                    catch (Exception e){

                        System.out.println("La familia introdicida no es valida");
                    }

                    System.out.println("");
                    break;

                case "3":
                    System.out.println("Cambiar de familia.");
                    System.out.println("Introduce el nombre de la persona a cambiar y a continuacion el de su futuro padre.");
                    String turncloak = teclado.nextLine();
                    String newParent = teclado.nextLine();
                    try{
                        got.changeFamily(turncloak,newParent);
                        LinkedTree<FamilyMember> newParentFamily = getFamilyByName(newParent);

                        got.printLinkedTree(newParentFamily);


                    }
                    catch (Exception e){
                       System.out.println("Alguno de los nombre introducidos no es valido");
                    }
                    System.out.println("");

                    break;
                case "4":
                    System.out.println("Consultar parentesco.");
                    System.out.println("Introduce dos nombre para comprobar si pertenecen a la misma familia");
                    try{
                        String name1 = teclado.nextLine();
                        String name2 = teclado.nextLine();
                        Boolean areFamily = got.areFamily(name1,name2);
                        if (areFamily == true){
                            System.out.println(name1+" y "+name2+" son de la misma familia");
                        }
                        else{
                            System.out.println(name1+" y "+name2+" no son de la misma familia");
                        }

                    }
                    catch(Exception e){
                        System.out.println("Alguno de los nombre introducidos no es valido");
                    }

                    System.out.println("");
                    break;
                case "5":
                    System.out.println("Saliendo del programa.");
                    break;
            }

        }
    }



}


