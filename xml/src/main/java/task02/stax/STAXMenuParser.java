package task02.stax;

import task02.model.Food;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;

/**
 * Created by wopqw on 20.10.16.
 */
@SuppressWarnings("WeakerAccess")
public class STAXMenuParser implements AutoCloseable {

    static ArrayList<Food> process (XMLStreamReader reader) throws XMLStreamException {

        ArrayList<Food> menu = new ArrayList<>();
        Food.FoodBuilder foodBuilder = null;
        MenuTagName elementName = null;

        while (reader.hasNext()) {

            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                    if (elementName == MenuTagName.FOOD)
                        foodBuilder = Food.builder()
                                .id(Integer.parseInt(
                                        reader.getAttributeValue(null, "id")));
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty())
                        break;

                    //noinspection ConstantConditions
                    switch (elementName) {
                        case NAME:
                            //noinspection ConstantConditions
                            foodBuilder.name(text);
                            break;
                        case PRICE:
                            //noinspection ConstantConditions
                            foodBuilder.price(text);
                            break;
                        case DESCRIPTION:
                            //noinspection ConstantConditions
                            foodBuilder.description(text);
                            break;
                        case CALORIES:
                            //noinspection ConstantConditions
                            foodBuilder.calories(Integer.parseInt(text));
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case FOOD:
                            //noinspection ConstantConditions
                            menu.add(foodBuilder.build());
                    }
            }
        }
        return menu;
    }

    @Override
    public void close() throws Exception {

    }
}
