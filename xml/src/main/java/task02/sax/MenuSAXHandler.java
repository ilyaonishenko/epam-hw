package task02.sax;

import lombok.Getter;
import lombok.extern.java.Log;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import task02.model.Food;

import java.util.ArrayList;

/**
 * Created by wopqw on 19.10.16.
 */
@Log
@SuppressWarnings("WeakerAccess")
public class MenuSAXHandler extends DefaultHandler {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Getter
    private ArrayList<Food> foods = new ArrayList<>();
    private Food.FoodBuilder foodBuilder;
    private StringBuilder text;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){

        log.info(() -> "startElement -> " + "uri: " + uri + ", localName: " + localName);

        text = new StringBuilder();

        if (localName.equals("food"))
            foodBuilder = Food.builder()
                    .id(Integer.parseInt(attributes.getValue("id")));
        else
            text = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        text.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        log.info(() -> "endElement -> uri: "+uri+", localName: "+localName);

        switch (localName) {
            case "name":
                foodBuilder.name(text.toString());
                break;
            case "price":
                foodBuilder.price(text.toString());
                break;
            case "description":
                foodBuilder.description(text.toString());
                break;
            case "calories":
                foodBuilder.calories(Integer.parseInt(text.toString()));
                break;
            case "food":
                foods.add(foodBuilder.build());
                foodBuilder = null;
        }
    }
}
