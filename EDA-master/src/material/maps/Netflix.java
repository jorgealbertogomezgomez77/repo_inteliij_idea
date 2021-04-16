package material.maps;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by David R on 14/06/2016.
 */
public class Netflix {

    private class Movie {
        String title;
        int year;
        ArrayList<Float> scores;
        ArrayList<String> genres;


        public Movie (String title, int year, ArrayList<Float> scores, ArrayList<String> genres){
            this.title = title;
            this.year = year;
            this.scores = scores;
            this.genres = genres;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public ArrayList<Float> getScores() {
            return scores;
        }

        public void setScores(ArrayList<Float> scores) {
            this.scores = scores;
        }

        public ArrayList<String> getGenres() {
            return genres;
        }

        public void setGenres(ArrayList<String> genres) {
            this.genres = genres;
        }

        public float getAverageScore(){
            float total = 0;

            for(float score: scores){
                total =+ score;
            }
           return  total/scores.size();
        }
        @Override
        public String toString() {
            String resultado ;
            float getAverageScore = getAverageScore();
            String generos = " ";
            for (String g : genres){
                generos = generos +" "+g;
            }


            return "Titulo: " + title + "\t Anio: " + year + "\t Puntuacion: " + getAverageScore + "\t Generos: " + generos;
        }

    }


    HashTableMapLP<String, Movie> hashtableTitle = new HashTableMapLP<>();
    HashTableMapLP<Integer, ArrayList<Movie>> hashtableYear = new HashTableMapLP<>();
    HashTableMapLP<String, ArrayList<Movie>> hashtablegenre = new HashTableMapLP<>();


    public void loadFile (String path) throws IOException {


        File file = new File(path); //Archivo
        Scanner scan = new Scanner(file);

        System.out.println("-----------------");


        while(scan.hasNext()) {
            String linea = scan.nextLine(); //guarda en linea la linea que se lee en cada momento
            //System.out.println("Linea leida: "+linea);
            String [] lineaDividida = linea.split(" - ");
            String movieTitle = lineaDividida[0];
            //System.out.println("titulo : "+movieTitle);
            Integer movieYear = Integer.valueOf(lineaDividida[1]);
            //System.out.println("anio : "+movieYear);
            String genres = lineaDividida[3].substring(1, lineaDividida[3].length()-1);
            //System.out.println("generos : "+genres);
            String splitGenres [] = genres.split(", ");
            ArrayList<String> gens = new ArrayList<>();
            for (int i=0; i<splitGenres.length; i++){
                gens.add (splitGenres[i]);
                //System.out.println("genero add : "+splitGenres[i]);
            }
            ArrayList<Float> scores = new ArrayList<>();
            //scores.add(Float.parseFloat(lineaDividida[2]));
            scores.add(Float.valueOf(lineaDividida[2]));
            //System.out.println("nota 1 : "+Float.valueOf(lineaDividida[2]));
            Movie movie = new Movie(movieTitle, movieYear, scores,gens );

            //System.out.println("imprimir pelicula  : "+ movie.toString());

            //Vamos rellenando la talaHash con el titulo(key) y la pelicula(value)
            hashtableTitle.put(movieTitle, movie);
            //System.out.println("Obtener  : "+ hashtableTitle.get(movieTitle));

            if(hashtableYear.get(movieYear) == null){//Si no hay ninguna pelicula de ese año en la tabla
                ArrayList<Movie>  list = new ArrayList<>();
                list.add(movie);
                hashtableYear.put(movieYear, list); //Le metemos la lista con una sola pelicula de ese año
            }
            else{
                ArrayList<Movie> list = hashtableYear.get(movieYear);
                list.add(movie);
            }


            //
            for(String g : gens){
                if(hashtablegenre.get(g)==null){
                    ArrayList<Movie> list = new ArrayList<>();
                    list.add(movie);
                    hashtablegenre.put(g,list);
                }
                else{
                    ArrayList<Movie> list = hashtablegenre.get(g);
                    list.add(movie);
                }
            }


        }
    }

    public Movie findTitle (String title){
        return hashtableTitle.get(title);
    }

    public ArrayList<Movie> findYear(int year){
        return hashtableYear.get(year);
    }

   public ArrayList<Movie> findType(String type){
       return hashtablegenre.get(type);

   }

    public ArrayList<Movie> findType(Set<String> type){
        ArrayList<Movie> movieList = new ArrayList<>();
        for (String genero :type){
            movieList.addAll(hashtablegenre.get(genero));
        }
        return movieList;
    }


    public void addScore(String title, float score){
        Movie movie = hashtableTitle.get(title);
        movie.getScores().add(score);

    }

    public ArrayList<Movie> findScore(float score){
        ArrayList<Movie> resultado = new ArrayList<>();

        Iterable<Entry<String, Movie>> entradas =  hashtableTitle.entries();
        for(Entry<String, Movie> entrada: entradas){
            if(entrada.getValue().getAverageScore()>=score){
                resultado.add(entrada.getValue());

            }

        }
        return resultado;
    }


    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }
    public static void main(String[] args) throws IOException, NoSuchFieldException{


        Netflix netflix = new Netflix();

        /*System.out.println(" ------------Probando!-----------");

        muestraContenido("C:\\Users\\David R\\IdeaProjects\\EDA\\src\\netflix.txt");

        System.out.println(" ------------Probando!-----------");*/


        //netflix.loadFile("C:\\Users\\David R\\IdeaProjects\\EDA\\src\\netflix.txt");
        //netflix.loadFile("C:\\Users\\David R\\IdeaProjects\\EDA\\src\\got_edited.txt");
        netflix.loadFile("D:\\IntelliJ IDEA Work\\EDA-master\\src\\netflix.txt");
        //D:\IntelliJ IDEA Work\EDA-master\src

        /*System.out.println(" ------------Probando!-----------");
        Iterable<Entry<String,Movie>> movies = netflix.hashtableTitle.entries();

        for(Entry<String, Movie> m :movies){
            m.getValue().toString();

        }
        System.out.println(" ------------Probando!-----------");*/

        Scanner teclado = new Scanner(System.in);
        String opcion = "";
        //opcion =teclado.nextLine();

        while (!opcion.equals("7")) {
            System.out.println(" ---------------------------------------------- ");
            System.out.println("|                   Netflix:                   |");
            System.out.println("|                   The App                    |");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("1 -> Buscar por titulo");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("2 -> Buscar por anio.");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("3 -> Buscar por nota.");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("4 -> Buscar por genero (solo 1).");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("5 -> Buscar por genero (Puede introducir varios).");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("6 -> Votar pelicula.");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("7 -> Salir.");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("\n");
            System.out.println("Selecciona una opcion.\n");
            opcion =teclado.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Buscar por titulo");
                    System.out.println("Introduzca el titulo de la pelicula a buscar");
                    try{
                        String titulo = teclado.nextLine();
                        System.out.println("La pelicula buscada es: ");
                        System.out.println(netflix.findTitle(titulo).toString());

                    }
                    catch (Exception e){
                        System.out.println("El titulo introdicida no es valido");
                    }
                    System.out.println("");
                    break;
                case "2":
                    System.out.println("Buscar por año.");
                    System.out.println("Introduzca el año de la pelicula");
                    try{
                        String anio = teclado.nextLine();
                        ArrayList<Movie> p =netflix.findYear(Integer.valueOf(anio));
                        System.out.println("La lista de peliculas del año introducido es: ");
                        for (Movie movie :p){
                            System.out.println(movie.toString());
                            System.out.println("");
                        }

                    }
                    catch (Exception e){

                        System.out.println("El año introdicido no es valido");
                    }

                    System.out.println("");
                    break;

                case "3":
                    System.out.println("Buscar por nota.");
                    System.out.println("Introduce la nota de corte.");
                    String nota = teclado.nextLine();
                    System.out.println("Las peliculas con esa nota o superior son: ");
                    try{
                        ArrayList<Movie> pelis = netflix.findScore(Float.valueOf(nota));
                        for(Movie m : pelis){
                            System.out.println(m.toString());
                            System.out.println("Buscar por nota.");

                        }


                    }
                    catch (Exception e){
                        System.out.println("La nota introducida no es valida");
                    }
                    System.out.println("");

                    break;
                case "4":
                    System.out.println("Buscar por genero (solo 1).");
                    System.out.println("Introduce un genero para buscar");
                    try{
                        String genero = teclado.nextLine();
                        ArrayList <Movie> p =netflix.findType(genero);
                        for (Movie m :p){
                            System.out.println(m.toString());
                            System.out.println("");
                        }

                    }
                    catch(Exception e){
                        System.out.println("El genero introducido no es valido");
                    }

                    System.out.println("");
                    break;
                case "5":
                    System.out.println("Buscar por genero (Puede introducir varios)");
                    System.out.println("Introduzca varios generos por los que");
                    try{
                        String op = "S";
                        ArrayList<String> tipos = new ArrayList<>();
                        Set<String> set1 = new HashSet<>();
                        while (op.equals("S")||op.equals("s")) {
                            System.out.println("Introduzca un genero");
                            String t2 = teclado.nextLine();
                            tipos.add(t2);
                            System.out.println("Quieres meter mas tipos? (S/N)");
                            op = teclado.nextLine();
                        }
                        if(tipos.size() == 1){
                            ArrayList <Movie> peliculas =netflix.findType(tipos.get(0));
                            for (Movie m :peliculas){
                                System.out.println(m.toString());
                                System.out.println("");
                            }
                        }
                        else{
                            for(int i = 0; i < tipos.size(); i++)
                                set1.add(tipos.get(i));
                            ArrayList<Movie> sm3 = netflix.findType(set1);
                            for(Movie m11 : sm3)
                                System.out.println(m11.toString());
                        }
                    }
                    catch (Exception e){
                        System.out.println("El titulo introdicida no es valido");
                    }
                    System.out.println("");
                    break;

                case "6":
                    System.out.println("Votar pelicula");
                    System.out.println("Introduzca el titulo de la pelicula y a continuacion la nota");
                    try{
                        String titulo = teclado.nextLine();
                        float valoracion = Float.valueOf(teclado.nextLine());

                        if(valoracion <= 5 || valoracion > 0){
                            netflix.addScore(titulo, valoracion);
                        }
                        else{
                            System.out.println("LA nota debe estar comprendida entre 0 y 5");
                        }

                    }
                    catch (Exception e){
                        System.out.println("El titulo o la nota introdicidos no son validos");
                    }
                    System.out.println("");
                    break;
                case "7":
                    System.out.println("Saliendo del programa.");
                    break;
            }

        }
    }
    }




