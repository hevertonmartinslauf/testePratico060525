
package utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Util {

    public Util() {
        
    }

    public boolean emailValido(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public boolean dataValida(String dataTexto) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(dataTexto, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public boolean salarioValido(String salario){
        
         try{
            Float.parseFloat(salario);
        }
        
        catch (Exception e){
            return false;
        }
         
         return true;
        
    }
   
    
    public String SenhaSha256(String senha){
        
        String senhaCriptografada;
        
         try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());

            // Converte o hash para uma string hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            senhaCriptografada = hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar a senha", e);
        }
         
        return senhaCriptografada; 
        
    }
    
}
