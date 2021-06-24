import no.bekk.bekkopen.person.Fodselsnummer;
import no.bekk.bekkopen.person.FodselsnummerCalculator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HashedSSN {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
        Base64.Encoder base64 = Base64.getEncoder();

        LocalDate date = LocalDate.of(1900, 1, 1);

        for (; date.isBefore(LocalDate.now()); date = date.plusDays(1)) {
            Date d = Date.from(date.atStartOfDay(ZoneId.of("Europe/Oslo")).toInstant());
            List<Fodselsnummer> fodselsnummerList = FodselsnummerCalculator.getManyFodselsnummerForDate(d);
            fodselsnummerList.forEach(f -> System.out.println(f + " - " + base64.encodeToString(sha512.digest(f.toString().getBytes(UTF_8)))));
        }

    }
}
