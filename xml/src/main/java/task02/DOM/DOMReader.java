package task02.DOM;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.val;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import task02.model.Food;

import java.util.ArrayList;

/**
 * Created by wopqw on 20.10.16.
 */
@Log
@SuppressWarnings("WeakerAccess")
public class DOMReader {

    private Element root;

    @SneakyThrows
    public DOMReader(String path) {
        DOMParser parser = new DOMParser();
        parser.parse(path);
        Document document = parser.getDocument();
        root = document.getDocumentElement();
    }

    public ArrayList<Food> parse() {

        ArrayList<Food> foods = new ArrayList<>();
        NodeList foodNodes = root.getElementsByTagName("food");

        for (int i = 0; i < foodNodes.getLength(); i++) {
            val foodBuilder = Food.builder();
            val foodElement = (Element) foodNodes.item(i);

            foodBuilder.id(Integer.parseInt(foodElement.getAttribute("id")));
            foodBuilder.name(getSingleChild(foodElement, "name").getTextContent().trim());
            foodBuilder.description(getSingleChild(foodElement, "description").getTextContent().trim());
            foods.add(foodBuilder.build());
        }
        log.info(foods::toString);

        return foods;
    }

    private static Element getSingleChild(Element element, String childName){

        NodeList list = element.getElementsByTagName(childName);
        return (Element)list.item(0);
    }
}
