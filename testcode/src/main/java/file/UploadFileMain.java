package file;

import okhttp3.*;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
/**
 * @author Arti.Jadhav
 */
public class UploadFileMain {
    public UploadFileMain() throws IOException {
    }

    public static void main(String[] args) {
        System.out.println("try main");
        byte[] byteData = downloadFile();
        String stream = Base64.getEncoder().encodeToString(byteData);
        // System.out.println(stream);


        /* byte[] byteData = base64ToByte(data);
         */
        uploadFile(byteData);

    }

    private static byte[] downloadFile() {
        String orn = "120-M-260-20220826-A181121";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://sitjdms.jio.com:8080/JDMSDL/rest/download/loadownload?order_ref_number=" + orn)
                .method("GET", null)
                .addHeader("username", "tibco")
                .addHeader("password", "5NTLlIhmIQfH4/8dXrjJ9g==")
                .build();
        byte[] byteData = null;
        try {
            Response response = client.newCall(request).execute();
            System.out.println("response:: ");
            byteData = response.body().bytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteData;
    }

    private static byte[] base64ToByte(String content) {
        byte[] name = Base64.getEncoder().encode(data.getBytes());
       /* byte[] decodedString = new byte[0];
        try {
            decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(new String(decodedString));*/
        return name;


    }

    private static void uploadFile(byte[] byteData) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        // System.out.println(new String(byteData));
        BASE64Decoder decoder = new BASE64Decoder();
      /*  byte[] decodedBytes = new byte[0];
        decodedBytes = Base64.getDecoder().decode(new String(byteData));*/
        // System.out.println(new String(byteData));
        // byte[] newBytes = Base64.getDecoder().decode(byteData);

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("username", "tibco")
                .addFormDataPart("password", "5NTLlIhmIQfH4/8dXrjJ9g==")
                /*.addFormDataPart("file","base64_test.pdf",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("/Users/arti.jadhav/Downloads/base64_test.pdf")))*/
                .addFormDataPart("file", "abc",
                        RequestBody.create(MediaType.parse("application/octet-stream"), byteData))
                .addFormDataPart("type", "144")
                .addFormDataPart("name", "AuthorizationFile")
                .addFormDataPart("order_ref_number", "120-M-260-20220826-A181130")
                .addFormDataPart("Document_MimeType", "application/pdf")
                .addFormDataPart("service_id", "8369447210")
                .build();
        Request request = new Request.Builder()
                .url("http://sitjdms.jio.com:8080/JDMSDL/rest/LOAupload")
                .method("POST", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("response..." + response);
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String base64File = "/Users/arti.jadhav/Desktop/c-drive data/Arti/Number Portablity/SIT/base64ForPdf.txt";

    static String data;

    static {
        try {
            data = new String(Files.readAllBytes(Paths.get(base64File)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
