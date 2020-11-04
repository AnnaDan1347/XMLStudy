package epam.by.application;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.stream.XMLStreamException;

public class GreenHouseRunner {
    public static void main(String[] args) throws IOException, XMLStreamException {
        GreenHouseXMLValidator validator = new GreenHouseXMLValidator("greenHouse.xml");
        
        if (validator.validate()) {
            GreenHouseXMLReader reader = new GreenHouseXMLReader();
            List<Plant> greenHouse = reader.read("greenHouse.xml");
            System.out.println("The file \"greenHouse.xml\" was read");

            // sort plants in greenHouse for sortedElement(averagePlantSize):

            Collections.sort(greenHouse, new Comparator<Plant>() {
                public int compare(Plant arg0, Plant arg1) {
                    return arg0.getSortedElement().compareTo(arg1.getSortedElement());
                }
            });

            System.out.println("Sorted list of plants (by average plant size):");

            for (Plant plant : greenHouse) {
                System.out.println(plant);
            }

            GreenHouseXMLWriter writer = new GreenHouseXMLWriter();
            writer.write(greenHouse, "greenHouse-new.xml");

            System.out.println("The file \"greenHouse-new.xml\" was created");
        } else {
            System.out.println("error" + validator.getError());
        }
    }
}
