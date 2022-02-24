package com.example.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class JwtApplicationTest {

    /**
     * 创建 token
     */
    @Test
    public void testCreatToken() {
        // 创建一个 JwtBuilder 对象
        JwtBuilder jwtBuilder = Jwts.builder()
                // 声明的标识 {"jti":"888"}
                .setId("888")
                // 主体，用户 {"sub":"Rose"}
                .setSubject("Rose")
                // 创建日期 {"ita":"时间戳"}
                .setIssuedAt(new Date())
                // 签名手段，参数1：算法，参数2：盐，最短四个字节
                .signWith(SignatureAlgorithm.HS256,"secret");

        // 获取jwt的token
        String token = jwtBuilder.compact();
        System.out.println(token);

        // 三部分的 base64 解密
        System.out.println("-----------------------");
        String[] split = token.split("\\.");
        // {"alg":"HS256"}
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        // {"jti":"888","sub":"Rose","iat":1645521982}
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        // 无法解密
        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
    }

    /**
     * 解析 token
     */
    @Test
    public void testParseToken(){
        // token
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjQ1NTIxOTgyfQ.MbC-RIpwtO2H2LGBeMobvul5950Io7eGt7bsH3L_luM";
        // 解析 token 获取负载中的声明对象
        Claims claims = Jwts.parser()
                // 盐
                .setSigningKey("secret")
                .parseClaimsJws(token)
                .getBody();
        // 打印声明的属性
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("issuedAt:"+claims.getIssuedAt());
    }

    /**
     * 创建有有效期 token
     */
    @Test
    public void testCreatTokenHasExp() {
        // 当前系统时间的长整型
        long now = System.currentTimeMillis();
        // 过期时间，这里是 1 分钟后的时间长整型
        long exp = now + 60 * 1000;
        // 创建一个 JwtBuilder 对象
        JwtBuilder jwtBuilder = Jwts.builder()
                // 声明的标识 {"jti":"888"}
                .setId("888")
                // 主体，用户 {"sub":"Rose"}
                .setSubject("Rose")
                // 创建日期 {"ita":"时间戳"}
                .setIssuedAt(new Date())
                // 签名手段，参数1：算法，参数2：盐，最短四个字节
                .signWith(SignatureAlgorithm.HS256, "secret")
                // 设置过期时间
                .setExpiration(new Date(exp));
        // 获取 jwt 的 token
        String token = jwtBuilder.compact();
        System.out.println(token);
    }

    /**
     * 解析有有效期的 token
     */
    @Test
    public void testParseTokenHasExp() {
        //token
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjQ1NTIzMDg5LCJleHAiOjE2NDU1MjMxNDl9.gBqm_dZZUIGpRvm8zoF4jC1DTe3D7oW2Jj5NGh5OMJM";
        // 解析 token 获取负载中的声明对象
        Claims claims = Jwts.parser()
                .setSigningKey("secret")
                .parseClaimsJws(token)
                .getBody();

        // 打印声明的属性
        System.out.println("id:" + claims.getId());
        System.out.println("subject:" + claims.getSubject());
        System.out.println("issuedAt:" + claims.getIssuedAt());
        DateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("签发时间:"+sf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sf.format(new Date()));
    }

    /**
     * 创建有自定义 claims 的 token
     */
    @Test
    public void testCreatTokenByClaims() {
        // 当前系统时间的长整型
        long now = System.currentTimeMillis();
        // 过期时间，这里是 1 分钟后的时间长整型
        long exp = now + 60 * 1000;
        // 创建一个 JwtBuilder 对象
        JwtBuilder jwtBuilder = Jwts.builder()
                // 声明的标识 {"jti":"888"}
                .setId("888")
                // 主体，用户 {"sub":"Rose"}
                .setSubject("Rose")
                // 创建日期 {"ita":"时间戳"}
                .setIssuedAt(new Date())
                // 签名手段，参数1：算法，参数2：盐
                .signWith(SignatureAlgorithm.HS256, "secret")
                // 设置过期时间
                .setExpiration(new Date(exp))
                // 直接传入map
                // .addClaims(map)
                .claim("roles","admin")
                .claim("logo","logo.jpg");
        // 获取 jwt 的 token
        String token = jwtBuilder.compact();
        System.out.println(token);
    }

    /**
     * 解析有自定义 claims 的 token
     */
    @Test
    public void testParseTokenByClaims() {
        //token
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjQ1NTIzOTYyLCJleHAiOjE2NDU1MjQwMjIsInJvbGVzIjoiYWRtaW4iLCJsb2dvIjoibG9nby5qcGcifQ.mmuz9T2lxkX7lRtD1Ha13k4v7Wxo0uW1MZqGQJmoILY";
        // 解析 token 获取负载中的声明对象
        Claims claims = Jwts.parser()
                .setSigningKey("secret")
                .parseClaimsJws(token)
                .getBody();

        // 打印声明的属性
        System.out.println("id:" + claims.getId());
        System.out.println("subject:" + claims.getSubject());
        System.out.println("issuedAt:" + claims.getIssuedAt());
        DateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("签发时间:"+sf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sf.format(new Date()));

        System.out.println("roles:"+claims.get("roles"));
        System.out.println("logo:"+claims.get("logo"));
    }
}
