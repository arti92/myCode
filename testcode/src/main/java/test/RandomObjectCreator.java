/*

package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jio.digitalapi.media.milestone.maintenance.service.datamodel.ReceiveMilestoneReqeust;
import org.apache.commons.lang.RandomStringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.*;


*/
/**
 * @author Arti.Jadhav
 *//*


public class RandomObjectCreator {
    private Random random = new Random();

    //by default will take all parents fields
    public <T> T createAndFill(Class<T> clazz) {
        return createAndFill(clazz,true);
    }

    public <T> T createAndFill(Class<T> clazz,Boolean isParent) {

        T instance = null;
        try {
            instance = clazz.newInstance();
            List<Field> inheritedFields = new ArrayList<>();
            if(isParent)
                inheritedFields = getInheritedFields(clazz);

            inheritedFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            for(Field field: inheritedFields) {
                field.setAccessible(true);
                // System.out.println("field:: "+field);
                Object value = getRandomValueForField(field);
                field.set(instance, value);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instance;
    }
    public <T> T createAndFillXML(Class<T> clazz) throws Exception {
        T instance = clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            if(field.getType().getName().equals("javax.xml.bind.JAXBElement")) {

                continue;
            }
            if(field.getType().getName().equals("java.util.List")) {

                continue;
            }
            Object value = getRandomValueForField(field);
            field.set(instance, value);
        }
        return instance;
    }

    public static List<Field> getInheritedFields(Class<?> type) {
        ArrayList inheritedFields = new ArrayList();
        Class superclass;

        for(inheritedFields = new ArrayList(); type.getSuperclass() != null; type = superclass) {
            superclass = type.getSuperclass();
            inheritedFields.addAll(Arrays.asList(superclass.getDeclaredFields()));
        }
        return inheritedFields;
    }

    private Object getRandomValueForField(Field field) throws Exception {
        Class<?> type = field.getType();
        try{
            if(type.isEnum()) {
                Object[] enumValues = type.getEnumConstants();
                return enumValues[random.nextInt(enumValues.length)];
            } else if(type.equals(Integer.TYPE) || type.equals(Integer.class)) {
                return random.nextInt(4);
            } else if(type.equals(Long.TYPE) || type.equals(Long.class)) {
                return random.nextLong();
            } else if(type.equals(Double.TYPE) || type.equals(Double.class)) {
                return random.nextDouble();
            } else if(type.equals(Float.TYPE) || type.equals(Float.class)) {
                return random.nextFloat();
            } else if(type.equals(String.class)) {
                return RandomStringUtils.random(8, true, false);
            } else if(type.getName().equals("java.util.List")) {
                ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
                Class<?> stringListClass = (Class<?>) stringListType.getActualTypeArguments()[0];
                Class c = Class.forName(stringListClass.getName());
                List<Object> finalList = new ArrayList();
                if(c.isInstance("String")){
                    finalList.add(RandomStringUtils.random(5, true, true));
                }else {
                    finalList.add(createAndFill(c));
                }
                return finalList;
            }else if(type.getName().equals("java.util.Date")) {
                return new Date();
            }
            else if(type.equals(BigInteger.class)){
                return BigInteger.valueOf(random.nextInt());
            }else {
                return createAndFill(type);
            }

        }catch (IllegalArgumentException e ){
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws JsonProcessingException {

            ReceiveMilestoneReqeust obj = new ReceiveMilestoneReqeust();
        RandomObjectCreator rc= new RandomObjectCreator();
        System.out.println(rc.createAndFill(ReceiveMilestoneReqeust.class));
        ObjectMapper mapper = new ObjectMapper();
        String a = mapper.writeValueAsString(rc.createAndFill(ReceiveMilestoneReqeust.class));
        System.out.println(a);
    }
}

*/
