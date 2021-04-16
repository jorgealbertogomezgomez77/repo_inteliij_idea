    /**public class GeneradorLibros {


        public ArrayList<Libro> generarLibros(int n){
            ArrayList<Libro> resultado=new ArrayList<Libro>();
            for(int i=0;i<n;i++){
                Libro l=new Libro(this.generarISBN(),this.generarTitulo(),this.generarAutor(),this.generarPrecio());
                resultado.add(l);
            }
            return resultado;
        }

        public String generarISBN(){
            Random r=new Random();
            String resultado="";
            for(int i=0;i<10;i++){
                if(i%3==0){
                    resultado+="-";
                }
                resultado+=Integer.toString(r.nextInt(10));
            }
            return resultado;
        }

        public String generarAutor(){
            String resultado="";
            Random r=new Random();
            String[] p1={"Antonio ","Gloria "};
            String[] p3={"Machado","Fuertes"};
            resultado=p1[r.nextInt(p1.length)]+p3[r.nextInt(p3.length)];
            return resultado;
        }

        public  String generarTitulo(){
            String resultado="";
            Random r=new Random();
            String[] p1={"Luna ","Sol ","Campo ","Aceras ","Campo ","Laguna ","Perros ","Gatos ","Saltamontes ","Lapiz ","Paredes ","Luciano "};
            String[] p2={"de ","el ","la ","los ","las ","con ","sin "};
            String[] p3={"Luna ","Sol ","Campo ","Aceras ","Campo ","Laguna ","Perros ","Gatos ","Saltamontes ","Lapiz ","Paredes ","Menta","Limon"};
            resultado+=(p1[r.nextInt(p1.length)]+p2[r.nextInt(p2.length)]+p3[r.nextInt(p3.length)]);
            return resultado;
        }

        public double generarPrecio(){
            Random r=new Random();
            return r.nextDouble()*100;
        }

    }
}*/
