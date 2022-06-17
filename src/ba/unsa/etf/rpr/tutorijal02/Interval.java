package ba.unsa.etf.rpr.tutorijal02;



public class Interval {
        private double t1, t2;
        private boolean p1, p2;


      //  konstruktor sa četiri parametra: početna tačka, krajnja tačka (obje tipa double), boolean vrijednost koja označava da li početna tačka pripada intervalu ili ne, te isto i za krajnju tačku; u slučaju da je početna tačka veća od krajnje treba baciti izuzetak tipa IllegalArgumentException;
        public  Interval ( double t1, double t2, boolean p1, boolean p2) throws IllegalArgumentException {
                if ( t1 > t2 ) throw new IllegalArgumentException();
                this.t1 = t1;
                this.t2 = t2;
                this.p1 = p1;
                this.p2 = p2;
        }

        //konstruktor bez parametara koji kreira "null interval" kod kojeg su početna i krajnja tačka 0 i niti jedna od njih ne pripada intervalu;
        public  Interval () {
                t1=0;
                t2=0;
                p1=false;
                p2=false;
        }

        //isNull koja vraća boolean vrijednost da li je interval null interval ili nije;
        public boolean isNull(){
                if( t1 == 0 && t2 == 0 || ( t1-t2 ) == 0 ) return true;
                return false;
        }

         //isIn metoda koja prima vrijednost tačke (tipa double) i vraća da li tačka pripada intervalu;

        public boolean isIn(double t){
                if ( t < t2 && t > t1 ) return true;
                if ( t == t1 && p1 == true ) return true;
                if ( t == t2 && p2 == true ) return true;
                return false;
        }
        //metodu intersect koja vraća presjek dva intervala: metoda treba biti urađena kao klasična public metoda (prima jedan interval) i
        // kao statička metoda (prima dva intervala);

        public Interval intersect ( Interval i) {
                Interval interval = new Interval();
                if (i.t1 > this.t2 || i.t2 < this.t1) return interval;

                if (this.t1 < i.t1 && i.t2 < this.t2) {
                        interval.t1 = i.t1;
                        interval.t2 = i.t2;
                        interval.p1 = i.p1;
                        interval.p2 = i.p2;
                }

                if (this.t1 == i.t1 && i.t2 == this.t2 ) {
                        interval.t1 = i.t1;
                        interval.t2 = i.t2;
                        interval.p1 = i.p1;
                        interval.p2 = i.p2;
                }

                if ( this.t1 <= i.t1 && this.t2>= i.t2 ) {
                        interval.t1 = i.t1;
                        interval.t2 = i.t2;
                        interval.p1 = i.p1;
                        interval.p2 = i.p2;

                }
                if ( this.t1 <= i.t1 && this.t2<= i.t2 ) {
                        interval.t1 = i.t1;
                        interval.t2 = i.t1;
                        interval.p1 = i.p1;
                        interval.p2 = i.p1;
                }

                if ( i.t1 <= this.t1 && i.t2>= this.t2 ) {
                        interval.t1 = this.t1;
                        interval.t2 = this.t2;
                        interval.p1 = this.p1;
                        interval.p2 = this.p2;

                }
                if ( i.t1 <= this.t1 && i.t2<= this.t2 ) {
                        interval.t1 = this.t1;
                        interval.t2 = this.t1;
                        interval.p1 = this.p1;
                        interval.p2 = this.p1;
                }

        return interval;
        }

        public static Interval intersect ( Interval i1, Interval i2 ){
                return i1.intersect(i2);
        }
 //također treba preklopiti metode klase Object a to su toString i equals,
        // na način koji ima smisla za te metode

        @Override
        public String toString(){
                String s = "";
                if(p1) s= s+"[";
                else s = s+"(";
                if( this.t1 != this.t2 ) s = s + t1+","+t2;
                if(p2) s = s+"]"; else s = s+")";
                return s;
        }

        @Override
        public boolean equals(Object obj) {
                if(obj instanceof Interval) {
                        return this.t1 == ((Interval) obj).t1 && this.t2 == ((Interval) obj).t2
                                && this.p2 == ((Interval) obj).p2 &&
                                this.p1 == ((Interval) obj).p1;
                }
                return false;
        }
        /*public double getT1() {
                return t1;
        }

        public void setT1(double t1) {
                this.t1 = t1;
        }

        public double getT2() {
                return t2;
        }

        public void setT2(double t2) {
                this.t2 = t2;
        }

        public boolean isP1() {
                return p1;
        }

        public void setP1(boolean p1) {
                this.p1 = p1;
        }

        public boolean isP2() {
                return p2;
        }

        public void setP2(boolean p2) {
                this.p2 = p2;
        }*/
}
