package epam.by.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class GreenHouseXMLReader {
    public List<Plant> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        try {
            List<Plant> greenHouse = new ArrayList<Plant>();
            Plant plant = null;
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    String tagName = reader.getLocalName();
                    switch (tagName) {
                    case "plant": {
                        plant = new Plant();
                        plant.setId(reader.getAttributeValue(null, "id"));
                        break;
                    }
                    case "name": {
                        plant.setName(reader.getElementText());
                        break;
                    }
                    case "soil": {
                        plant.setSoil(Soil.valueOf(reader.getElementText()));
                        break;
                    }
                    case "origin": {
                        plant.setOrigin(reader.getElementText());
                        break;
                    }
                    case "stemColor": {
                        StemColor stemColor = new StemColor();
                        stemColor.setElement(tagName);
                        stemColor.setValue(reader.getElementText());
                        plant.getVisual().add(stemColor);
                        break;
                    }
                    case "leafColor": {
                        LeafColor leafColor = new LeafColor();
                        leafColor.setElement(tagName);
                        leafColor.setValue(reader.getElementText());
                        plant.getVisual().add(leafColor);
                        break;
                    }
                    case "averagePlantSize": {
                        AveragePlantSize size = new AveragePlantSize();
                        size.setElement(tagName);
                        size.setValue(reader.getElementText());
                        plant.getVisual().add(size);
                        
                        //for sorting greenhouse by AveragePlantSize
                        plant.setSortedElement(Integer.parseInt(size.getValue()));
                        break;
                    }
                    case "temperatureDegree": {
                        TemperatureDegree temperature = new TemperatureDegree();
                        temperature.setElement(tagName);
                        temperature.setValue(reader.getElementText());
                        plant.getGrowingTips().add(temperature);
                        break;
                    }

                    case "lighting": {
                        Lighting lighting = new Lighting();
                        lighting.setElement(tagName);
                        lighting.setValue(reader.getElementText());
                        plant.getGrowingTips().add(lighting);
                        break;
                    }

                    case "wateringPerWeek": {
                        WateringPerWeek watering = new WateringPerWeek();
                        watering.setElement(tagName);
                        watering.setValue(reader.getElementText());
                        plant.getGrowingTips().add(watering);
                        break;
                    }
                    case "multiplying": {
                        plant.setMultiplying(Multiplying.valueOf(reader.getElementText()));
                        break;
                    }
                    }break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    String tagName = reader.getLocalName();
                    if ("plant".equals(tagName)) {
                        greenHouse.add(plant);
                    }
                    break;
                }
                }
            }
            return greenHouse;
        } catch (XMLStreamException e) {
            return null;
        } finally {
            try {
                reader.close();// try-with-resourse!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            } catch (Exception e) {
            }
        }
    }
}
