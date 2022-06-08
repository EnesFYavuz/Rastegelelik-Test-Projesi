/**
*
* @author Enes Furkan Yavuz enes.yavuz3@ogr.sakarya.edu.tr 
* @since 25.04.2021
* <p>
* Rastgele harf ve cumle ureten yazilim 
* </p>
*/
package pkt;

public class RasgeleSayilarTest {
	 public static void main(String[] args)
	    {
		 RasgeleSayiUret nesne = new RasgeleSayiUret();
		  System.out.println("Rastgele Karakter:"+nesne.RastChar());
		  System.out.println("Rastgele Karakter:"+nesne.RastChar());
		  System.out.print("Rastgele 3 karakter:");
		  System.out.println(nesne.RandomChars(3));
		  System.out.print("Rastgele 3 karakter:");
		  System.out.println(nesne.RandomChars(3));
		  System.out.print("Verilen bir karakter (a,k):");
		  System.out.println(nesne.RandomCharUzun(1, 'a','k'));
		  System.out.print("Verilen iki karakter (a,k):");
		  System.out.println(nesne.RandomCharUzun(2, 'a','k'));
		  System.out.print("Belirtilen Karakterler (g,y,u,c,n,e):");
		  System.out.println(nesne.GirilenCharlar(1,'g','y','u','c','n','e'));
		  System.out.print("Belirtilen Karakterler (g,s,u,c,n,e):");
		  System.out.println(nesne.GirilenCharlar(2,'g','s','u','c','n','e'));
		  System.out.print("Rastgele Cümle:");
		  char[][] cumleKur = nesne.CumleKur(8,8);
		  for (int i = 0; i < cumleKur.length; i++) {
	            for (int j = 0; j < cumleKur[i].length; j++) {
	              System.out.print(cumleKur[i][j]);
	            }
	        }
		 
	    }

}
