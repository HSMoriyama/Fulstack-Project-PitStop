package projeto.pitstop.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import projeto.pitstop.model.Usuario;

/*
 * QUANDO O USER FOR SE CADASTRAR, É CRIADO UM TOKEN PARA ELE,
 * QUAND ELE FOR ACESSAR UM ENDPOINT QUE PRECISA DE AUTENTICAÇÃO,
 * ELE PRECISA PASSAR O TOKEN, AÍ É CHAMADO O MÉTODO VALIDATE(),
 * PARA VERIFICAR SE O TOKEN É VÁLIDO
 */

//CLASSE PARA GERAR E VALIDAR TOKEN
public class TokenUtil {

	private static final String HEADER = "Authorization";
	
	private static final String PREFIX = "Bearer "; //TIPO DO TOKEN - DEFAULT
	
	//EXPIRATION => qtdHrs*hrs*mins*mileseconds
	private static final long EXPIRATION = 12*60*60*1000;

	private static final String SECRET_KEY = "MyK3Yt0T0kenP4r@S3CuRiTY@Sp3c14L";

	private static final String EMISSOR = "Pit-Stop-Security";
	
	
	//MÉTODO PARA GERAR TOKEN
	public static String createToken(Usuario user) {
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		
		String token = Jwts.builder()
						   .setSubject(user.getNome())//A QUEM SE REFERÊNCIA
						   .setIssuer(EMISSOR)
						   .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
						   .signWith(secretKey, SignatureAlgorithm.HS256)
						   .compact();
		
		return PREFIX + token;
	
	}
	
	//METODO PARA VÁLIDAR TEMPO DE EXPIRAÇÃO DO TOKEN 
	private static boolean isExpirationValid(Date expiration) {
		return expiration.after(new Date(System.currentTimeMillis()));
	}
	
	//METODO PARA VÁLIDAR EMISSOR DO TOKEN 
	private static boolean isEmissorValid(String emissor) {
		return emissor.equals(EMISSOR);
	}
	
	//METODO PARA VÁLIDAR OBJ DE REFERENCIA DO TOKEN
	//VERIFICA SE USER É O MESMO
	private static boolean isSubjectValid(String username) {
		return username != null && username.length() > 0;
	}
	
	
	//VALIDA O TOKEN ENCAMINHADO NA REQUEST								
										  //PASSA O FILTRO, O QUAL VERIFICA SE A REQUISIÇÃO 
										  //É ABERTA OU SE PRECISA DE AUTENTICAÇÃO
	public static Authentication validate(HttpServletRequest request) {
		
		//REMOVENDO PREFIXO PARA OBTER SOMENTE O TOKEN
		String token = request.getHeader(HEADER);
		token = token.replace(PREFIX, "");
		
		//PEGANDO INFOS DO PAYLOAD - USER, CHAVE...
		Jws<Claims> jwsClaims = Jwts.parserBuilder()
									.setSigningKey(SECRET_KEY.getBytes())
									.build()
									.parseClaimsJws(token);
		
		//PEGA OBJ DE REFERENCIA, OU SEJA USER E DEMAIS DADOS.
		String username = jwsClaims.getBody().getSubject();
		String issuer = jwsClaims.getBody().getIssuer();
		Date expira = jwsClaims.getBody().getExpiration();
		
		//APOS RECUPERAR OS DADOS ACIMA, CHAMAREMOS OS METODOS DE VALIDAÇÃO DESSES DADOS,
		//PARA VERIFICAR SE USER, EMISSOR E EXPIRAÇÃO SÃO VÁLIDOS.
		if(isSubjectValid(username) && isEmissorValid(issuer) && isExpirationValid(expira)) {
			
			//SE TRUE, DEVOLVE UMA INSTÂNCIA DE OBJ DE AUTENTICAÇÃO TOKEN 
																//=> tipoUser e endpoints que pode acessar
			return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
		}
		
		
		return null;
		
	} 
	
}