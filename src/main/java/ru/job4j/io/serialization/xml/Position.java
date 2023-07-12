package ru.job4j.io.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "position")
@XmlAccessorType(XmlAccessType.FIELD)
public class Position {

    @XmlAttribute
    private String title;

    @XmlAttribute
    private int grade;

    private Person person;

    @XmlAttribute
    private boolean occupied;

    @XmlElementWrapper(name = "requirements")
    @XmlElement(name = "req")
    private String[] requirements;

    public Position() {
    }

    public Position(String title, int grade, Person person, boolean occupied, String... requirements) {
        this.title = title;
        this.grade = grade;
        this.person = person;
        this.occupied = occupied;
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        return "Position{"
                + "title='" + title + '\''
                + ", grade=" + grade
                + ", person=" + person
                + ", occupied=" + occupied
                + ", requirements=" + Arrays.toString(requirements)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        final Position position = new Position("Director", 10, new Person("Eugene", false, 30,
                new Contact("333-33-33"), "manager"), true,
                "Higher education", "Connections", "Experience");
        JAXBContext context = JAXBContext.newInstance(Position.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(position, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Position result = (Position) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
