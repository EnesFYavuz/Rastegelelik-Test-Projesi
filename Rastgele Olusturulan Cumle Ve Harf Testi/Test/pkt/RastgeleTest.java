/**
*
* @author Enes Furkan Yavuz enes.yavuz3@ogr.sakarya.edu.tr 
* @since 25.04.2021
* <p>
* Rastgele harf ve cumle ureten yazilim testi
* </p>
*/
package pkt;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.github.javafaker.Faker;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RastgeleTest {
	public static RasgeleSayiUret nesne;
	
	@BeforeAll
	public static void setup() {
		nesne = new RasgeleSayiUret();
	}
	@Test
	@DisplayName("Döndürülen deðisken karakter mi testi")
	void RastCharTest() {
		char karakter = nesne.RastChar();
		assertTrue(karakter >= 'A' && karakter <= 'Z' || karakter >= 'a' && karakter <= 'z' );
	}
	@Test
	@DisplayName("Döndürülen deðisken karakter mi mock testi")
	void RastCharmockTest() {
		RasgeleSayiUret rastgeleHarf = mock(RasgeleSayiUret.class);
		when(rastgeleHarf.RastChar()).thenReturn('a');
		assertEquals('a',rastgeleHarf.RastChar());
	}
	@Test
	@DisplayName("Olusrulacak harf adetinin negatif sayi verilme testi")
	void RandomCharNegatifParametreTest() {
		assertThrows(NegativeArraySizeException.class, ()->{
			nesne.RandomChars(-1);
		});
		
	}
	@DisplayName("Istenilen adet sayisindaki harf sayisi beklenen harf sayisina esitmi")
	@ParameterizedTest
	@CsvSource({"2,2","3,3","4,4","5,5"})
	void RandomCharsTest(int adet,int expected) {
		char karakter[]=nesne.RandomChars(adet);
		assertEquals(expected,karakter.length);
	}
	@DisplayName("Istenilen adet sayisindaki harf sayisi olsuturulan harf sayisina esitmi mock test")
	@Test
	void RandomCharsMockTest() {
		RasgeleSayiUret adet = mock(RasgeleSayiUret.class);
		char[] harfler = {'a','b'};
		when(adet.RandomChars(2)).thenReturn(harfler);
		assertEquals(harfler.length,adet.RandomChars(2).length);
	}
	@Test
	@DisplayName("Dondurulen karakterler verilen iki karakter icindemi testi")
	void RandomCharTest() {
		char karakter = nesne.RandomChar('a','z');
		assertTrue(karakter >= 'a' && karakter <= 'z');	
	}
	@Test
	@DisplayName("Dondurulen karakterler verilen iki karakter icindemi mock testi")
	void RandomCharMockTest() {
		RasgeleSayiUret rastgeleHarf = mock(RasgeleSayiUret.class);
		when(rastgeleHarf.RandomChar('a','z')).thenReturn('s');
		assertEquals('s',rastgeleHarf.RandomChar('a','z'));
	}
	@Test
	@DisplayName("Rastgele olusturulan karakteler arasinda karakter olusturma testi")
	void RandomCharFakerTest() {
		Faker faker = new Faker();
		char ilk,son = ' ';
		do {
			 ilk = faker.lorem().character();
			 son = faker.lorem().character();
		} while(!((ilk>='a' && ilk<='z') && (son>='a' && son<='z')));
		char karakter = nesne.RandomChar(ilk,son);
		assertTrue(karakter >= ilk && karakter <= son || karakter >= son && karakter <= ilk);	
	}
	@Test
	@DisplayName("Istenilen adette olusturulan karakterler istenilen aralikta mi testi")
	void RandomCharUzunTest() {
		char karakter[]=nesne.RandomCharUzun(2,'a','z');
		for(int i=0;i<2;i++) {
			assertTrue(karakter[i] >= 'a' && karakter[i] <= 'z');	
		}
	}
	@Test
	@DisplayName("Istenilen adette olusturulan mock nesnesindeki karakterler istenilen aralikta mi testi")
	void RandomCharUzunMockTest() {
		RasgeleSayiUret rastgeleHarf = mock(RasgeleSayiUret.class);
		char[] harfler = {'b','k'};
		when(rastgeleHarf.RandomCharUzun(2, 'a','z')).thenReturn(harfler);
		assertEquals(harfler,rastgeleHarf.RandomCharUzun(2, 'a','z'));
	}
	@Test
	@DisplayName("Istenilen uzunlukta olusturulan mock nesnesindeki karakterler istenilen uzunlukta mi testi")
	void RandomCharUzunAdetMockTest() {
		RasgeleSayiUret rastgeleHarf = mock(RasgeleSayiUret.class);
		char[] harfler = {'d','k'};
		when(rastgeleHarf.RandomCharUzun(4, 'a','z')).thenReturn(harfler);
		assertEquals(harfler.length,rastgeleHarf.RandomCharUzun(4, 'a','z').length);
	}
	@Test
	@DisplayName("Karakter uzunlugunun negatif verilmesi testi")
	void RandomCharUzunBosGelmesiTest() {
		assertThrows(NegativeArraySizeException.class, ()->{
			nesne.RandomCharUzun(-1, 'a', 'z');
		});
	}
	@Test
	@DisplayName("Aralikta istenilen karakterler harf mi tesi")
	void RandomCharUzunIllegalArgumentGelmesiTest() {
		assertThrows(IllegalArgumentException.class, ()->{
			nesne.RandomCharUzun(2,'-','+');
		});
	}
	@Test
	@DisplayName("Rastgele sayida adedince verilen  karakterler istenilen karakter araligindami testi ")
	void RandomCharUzunFakerTest() {
		Faker faker = new Faker();
		int adet = faker.number().randomDigit();
		char karakter[]=nesne.RandomCharUzun(adet,'a','z');
		for(int i=0;i<adet;i++) {
			assertTrue(karakter[i] >= 'a' && karakter[i] <= 'z');	
		}
	}
	@ParameterizedTest
	@CsvSource({"2,2","3,3","4,4","5,5"})
	void RandomCharUzunAdetTest(int adet,int expected) {
		char karakter[]=nesne.RandomCharUzun(adet,'a','z');
		assertEquals(expected,karakter.length);
	}
	@Test
	@DisplayName("Verilen karakterler arasindan karakter secildimi")
	void GirilenCharlarTest() {
		char karakter[]=nesne.GirilenCharlar(1,'g','y','u','c');
		for(int i=0;i<karakter.length;i++) {
			assertTrue(karakter[i] == 'g' || karakter[i] == 'y'|| karakter[i] == 'u'|| karakter[i] == 'c' );	
		}
		
	}
	@Test
	@DisplayName("Verilen karakterler arasindan karakter secildimi")
	void GirilenCharlarUzunluguMockTest() {
		RasgeleSayiUret rastgeleHarf = mock(RasgeleSayiUret.class);
		char[] harfler = {'g'};
		when(rastgeleHarf.GirilenCharlar(1,'g','y','u','c')).thenReturn(harfler);
		assertEquals(harfler.length,rastgeleHarf.GirilenCharlar(1,'g','y','u','c').length);
		
	}
	@Test
	@DisplayName("Verilen karakterler arasindan karakter secildimi")
	void GirilenCharlarUzunlukTest() {
		Faker faker = new Faker();
		int adet = faker.number().randomDigit();
		char karakter[]=nesne.GirilenCharlar(adet,'g','y','u','c');
		assertEquals(adet,karakter.length);
	}
	@Test
	@DisplayName("Girilen karakterlerin dondurulken bos gelmesi")
	void GirilenCharlarinAdetininNegatifOlmasiTest() {
		assertThrows(NegativeArraySizeException.class, ()->{
			nesne.GirilenCharlar(-1,'g','y','u','c');
		});
	}
	@Test
	@DisplayName("Girilen karakterlerin harf olmasi")
	void GirilenCharlarinHarfOlmasiTest() {
		assertThrows(IllegalArgumentException.class, ()->{
			nesne.GirilenCharlar(1,'g','+','-','=');
		});
	}
	@ParameterizedTest
	@DisplayName("Verilen adet kadar karakter secildi mi testi")
	@CsvSource({"1,1","2,2","3,3","4,4"})
	void GirilenCharlarAdetTest(int adet,int expected) {
		char karakter[]=nesne.GirilenCharlar(adet,'g','y','u','c');
		assertEquals(expected,karakter.length);
	}
	@Test
	@DisplayName("Cumlenin harflerinin kucuk olmasi testi")
	void CumleKurTest() {
		char[][] cumleKur = nesne.CumleKur(5,6);
		 for (int i = 0; i < cumleKur.length; i++) {
	            for (int j = 0; j < cumleKur[i].length-1; j++) {
	            	assertTrue(cumleKur[i][j] >= 'a' && cumleKur[i][j] <= 'z');	
	            }
	        }
	}
	@Test
	@DisplayName("Istenilen harfler verilerek olsuturulan cumlenin istenilen cumle olmasi mock testi")
	void CumleKurMockTest() {
		RasgeleSayiUret cumle = mock(RasgeleSayiUret.class);
		char[][] cumleKur= {{'a','s','c'},{'d','g','k'}};
		when(cumle.CumleKur(1, 2)).thenReturn(cumleKur);
		assertEquals(cumleKur,cumle.CumleKur(1, 2));
	}
	@Test
	void CumleKurMockAdetTest() {
		RasgeleSayiUret cumle = mock(RasgeleSayiUret.class);
		char[][] cumleKur= {{'s','c','k'},{'y','u','o'}};
		when(cumle.CumleKur(1, 2)).thenReturn(cumleKur);
		assertEquals(cumleKur.length,cumle.CumleKur(1, 2).length);
	}
	@ParameterizedTest
	@DisplayName("Cumlede verilen kelime sayisinin beklenen kelime sayisina esit olmasi testi ")
	@CsvSource({"1,1","2,2","3,3","4,4"})
	void CumleSayisiTest(int adet,int expected) {
		char[][] cumleKur = nesne.CumleKur(adet,6);
		assertEquals(expected,cumleKur.length);
	}
	@Test
	@DisplayName("Cumledeki ilk karakterin kucuk harf olmasi testi")
	void CumleBaslangicKarakterTest() {
		char[][] cumleKur = nesne.CumleKur(2,4);
		assertTrue(cumleKur[0][0] >= 'a' && cumleKur[0][0] <= 'z');
	}
	@Test
	@DisplayName("Cumledeki son karakteri nokta karakteri olmasi testi")
	void CumleSonKarakterTest() {
		char[][] cumleKur = nesne.CumleKur(5,6);
		int son = cumleKur[0].length-1;
		int baslangic = cumleKur.length-1;
		assertTrue(cumleKur[baslangic][son]=='.');
		
	}
	@Test
	@DisplayName("Rastgele kelime uzunlugu olsuturulan kelime uzunluguna esit mi testi")
	void CumleKelimeleriUzunluguTest() {
		Faker faker = new Faker();
		int beklenenUzunluk;
		do {
		 beklenenUzunluk = faker.number().randomDigit();
		}while(beklenenUzunluk==0);
		char[][] cumleKur = nesne.CumleKur(5,beklenenUzunluk);
		int kelimeuzunlugu=cumleKur[0].length;
		assertEquals(beklenenUzunluk,kelimeuzunlugu);
	}
	@Test
	@DisplayName("Rastgele kelime sayisi olsuturulan kelime sayisina esit mi testi")
	void CumleKelimeleriSayisiRastgeleSayiTest() {
		Faker faker = new Faker();
		int  rastgeleKelimeSayisi= faker.number().randomDigit();
		char[][] cumleKur = nesne.CumleKur(rastgeleKelimeSayisi,4);
		int kelimeSayisi=cumleKur.length;
		assertEquals(rastgeleKelimeSayisi,kelimeSayisi);
	}
	@Test
	@DisplayName("Karakter uzunlugunun veya kelime adetinin negatif verilmesi testi")
	void CumleKurVerilenParametrelerinNegatifOlmasi() {
		assertThrows(NegativeArraySizeException.class, ()->{
			nesne.CumleKur(-1, -1);
		});
	}

}
