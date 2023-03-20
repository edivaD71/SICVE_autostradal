package com.bean;

//creo la class auto 

public class auto {
        private String targa;
        private String marca;
        private String modello;
        private int anno;
        private String email;

        

		public auto(String targa,String marca, String modello,int anno,String email)
        {
            this.targa = targa;
            this.marca = marca;
            this.modello = modello;
            this.anno = anno;
            this.email = email;
           
            

    }

		public String getTarga() {
			return targa;
		}



		public String getMarca() {
			return marca;
		}



		public String getModello() {
			return modello;
		}



		public int getAnno() {
			return anno;
		}



		public String getEmail() {
			return email;
		}


}
