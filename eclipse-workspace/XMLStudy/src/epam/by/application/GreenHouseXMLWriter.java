package epam.by.application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class GreenHouseXMLWriter {
    public void write(List<Plant> greenHouse, String fileName) throws FileNotFoundException, XMLStreamException {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("greenHouse");
            writer.writeAttribute("xmlns:xsi", "http://www.example.org/greenHouse");
            writer.writeAttribute("xmlns", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/greenHouse greenHouse.xsd");
            for (Plant plant : greenHouse) {
                writer.writeStartElement("plant");
                writer.writeAttribute("id", plant.getId());
                writer.writeStartElement("name");
                writer.writeCharacters(plant.getName());
                writer.writeEndElement();
                writer.writeStartElement("soil");
                writer.writeCharacters(plant.getSoil().toString());
                writer.writeEndElement();
                writer.writeStartElement("origin");
                writer.writeCharacters(plant.getOrigin());
                writer.writeEndElement();
                writer.writeStartElement("visual");
                for (AVisual visual : plant.getVisual()) {
                    writer.writeStartElement(visual.getElement());
                    writer.writeCharacters(visual.getValue());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeStartElement("growingTips");
                for (AGrowingTips tips : plant.getGrowingTips()) {
                    writer.writeStartElement(tips.getElement());
                    writer.writeCharacters(tips.getValue());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeStartElement("multiplying");
                writer.writeCharacters(plant.getMultiplying().toString());
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}
