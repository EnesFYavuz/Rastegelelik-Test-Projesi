/**
*
* @author Enes Furkan Yavuz enes.yavuz3@ogr.sakarya.edu.tr 
* @since 25.04.2021
* <p>
* Rastgele harf ve cumle ureten yazilim sinifi
* </p>
*/
package pkt;
import java.util.Random;

public class RasgeleSayiUret {
	 public char RastChar()//Rastgele karakter uretiliyor
	    {
		char karakter = 0;
		int temp;
		Random r=new Random();
		int rasgelesayi = r.nextInt(10);//0-10 arasi ratgele deger olusturuluyor
	//Burda buyuk harf olabilmesi icin bir rastgelelik.
		if ( rasgelesayi % 2 == 0)
		{
		    temp = r.nextInt(26)+65;
	// ASCII da 65 ila 90 arasindaki sayilar aliniyor.
		}
	//else ifadesi kucuk harf icin.
		else
		{
	// 97 ila 122 arasý sayilar aliniyor.
			temp = r.nextInt(26)+97;
		}
	//Tempden gelen integer chara aktariliyor ve returnle donduruluyor.
		karakter = (char) temp;
		if(karakterTest(karakter)==false) throw new IllegalArgumentException();//karakterin harf olup olmadigi test ediliyor
		return karakter;
	    }
	 public boolean karakterTest(char ch1) {//Karakterin harf olup olmadigi kontrol ediliyor
		 if(!((ch1>=65 && ch1<=90) || (ch1>=97 && ch1<=122))) return false;
		 return true;
	 }
	 public char[]  RandomChars (int sayi) {
		 if(sayi<0) throw new NegativeArraySizeException();//Harf adetinin negatif olup olmadigi kontrol ediliyor
		char harfler[] = new char[sayi];
			for(int i=0;i<sayi;i++) {
				harfler[i] = RastChar();//Istenilen sayi kadar harf uretiliyor
			}
			return harfler;
		}
	public  char RandomChar(char ch1,char ch2) {//Iki karakter araliginda karakter uretiyor
			return (char) ( ch1 + Math.random() * ( ch2 - ch1 + 1));
	}
	public  char[] RandomCharUzun(int sayi,char ch1,char ch2) {
		 if(sayi<0) throw new NegativeArraySizeException();//Adetlerinin negatif olup olmadigi kontrol ediliyor
		 //Karakterlerin harf olup olmaigi kontrol ediliyor
		 if(!((ch1>=65 && ch1<=90) && (ch2>=65 && ch2<=90) || (ch1>=97 && ch1<=122) && (ch2>=97 && ch2<=122) )) throw new IllegalArgumentException();
		char harfler[] = new char[sayi];
		for(int i=0;i<sayi;i++) {
			harfler[i]=RandomChar(ch1, ch2);//Istenilen sayi kadar secilen karakterler arasi sayi uretiliyor
		}
		return harfler;
	}
	  public char[] GirilenCharlar(int a , char... temp)
	    {
		  if(a<0) throw new NegativeArraySizeException();
	//Cikti icin duzenli bir gosterim.
		//System.out.print("Belirtilen Karakterler(");
		char harfler[] = new char[a];
	//Girilen karakterler harfmi diye kontrol ediliyor
		for(int i=0;i<temp.length;i++)
		{
			if(karakterTest(temp[i])==false) throw new IllegalArgumentException(); 
		}
			//System.out.print("):");
		Random rastgele=new Random(); //random sýnýfý
	//For dongusunde kac tane karakter istendiyse o kadar karakter cikartmak icin.
		for(int i=0;i<a;i++)
		{
	//secici char dizisinden rastgele secmek icin.
		    int harfSayisi=rastgele.nextInt(temp.length);
		    harfler[i]=temp[harfSayisi];
		}
		return harfler;
	    }
	  public char[][] CumleKur(int kelimesayisi,int kelimeuzunlugu)
	    {
		  //Kelime uzunlugunun ve kelime sayisinin negatif verildigi kontor ediliyor
		  if(kelimesayisi<0 || kelimeuzunlugu<0) throw new NegativeArraySizeException();
		int kelimedurdurma=0;
		char[][] cumle =new char[kelimesayisi][kelimeuzunlugu];
	//Output icin duzenli bir cikis saglandiktan sonra while icinde kac tane kelime isteniyorsa o kadar kelime uretiliyor.
		while(kelimedurdurma<kelimesayisi)
		{
		    for(int i=0;i<kelimeuzunlugu;i++)
		    {
			char x=RastChar();
	//if de kelimelerin kucuk harf olmasi saglaniyor cumlede full kucuk harf olusmasi icin.
			if((int)x<97)
			{
			    x=(char)((int)x+32);
			}
			cumle[kelimedurdurma][i]=x;
		    }
	//Bu ifde son kelime haric diger kelimelerden sonra bosluk birakiliyor.
		    if(kelimedurdurma+1!=kelimesayisi)
		    {
		    	 cumle[kelimedurdurma][kelimeuzunlugu-1]= ' ';
		    	
		    	
		    }
	//Bu ifde de son kelimeden sonra nokta koyuluyor.
		    if(kelimedurdurma+1==kelimesayisi)
		    {
		    	cumle[kelimedurdurma][kelimeuzunlugu-1]= '.';
		    	
		    }
		    kelimedurdurma++;
		}
		return cumle;
	    }
	
}
