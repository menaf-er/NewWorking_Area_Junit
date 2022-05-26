package day_11_FakerName_FileExist;

import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir")); // icinbde oldgum projenın dosya yolunu verir (Path)

        System.out.println(System.getProperty("user.home")); // benim pc min bana ozel kısmını verdi.

        // masaustundeki text dosyasının varlıgını test edin

        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\hamza yılmaz gıthub page.txt";

        System.out.println("dosya yolu : "+ dosyaYolu);

         /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin
         her bilgisayarin birbirinden farkli olan yolunu bulmak icin
         */
        String farkliKisim= System.getProperty("user.home");
        // herkesin bilgisayarinda ortak olan kisim ise

        String ortakKisim="\\Desktop\\text.txt";
        // mac icin   "/Desktop/text"

        String masaustuDosyaYolu = farkliKisim + ortakKisim ;

        System.out.println(masaustuDosyaYolu);

        System.out.println(Files.exists(Paths.get("masaustuDosyaYolu")));

    }
}

