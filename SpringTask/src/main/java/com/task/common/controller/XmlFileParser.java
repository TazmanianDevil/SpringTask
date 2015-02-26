package com.task.common.controller;

import com.task.common.model.Customer;
import com.task.common.model.Order;
import com.task.common.model.Position;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Musin on 26.02.2015.
 */
public class XmlFileParser {

    static ArrayList<Customer> parseFile(File fileName) {
        ArrayList<Customer> c = new ArrayList<Customer>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(fileName);
            Element customersRoot = doc.getDocumentElement();
            NodeList customers = customersRoot.getElementsByTagName("customer");
            for (int i = 0; i < customers.getLength(); i++) {
                Customer temp = new Customer();
                Element customer = (Element)customers.item(i);
                if (customer.getElementsByTagName("id").item(0).getFirstChild() == null)
                    temp.setId(null);
                else
                    temp.setId(Integer.parseInt(customer.getElementsByTagName("id").item(0).getFirstChild().getNodeValue()));
                temp.setName(customer.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
                NodeList orders = customer.getElementsByTagName("order");
                //Создаем список заказов для Customer
                List<Order> orderList = new ArrayList<Order>(orders.getLength());
                for (int j = 0; j < orders.getLength(); j++) {
                    Order o = new Order();
                    Element order = (Element)orders.item(j);
                    if (order.getElementsByTagName("id").item(0).getFirstChild() != null )
                        o.setId(Integer.parseInt(order.getElementsByTagName("id").item(0).getFirstChild().getNodeValue()));
                    else
                        o.setId(null);
                    //Создаем список позиций в заказе для Order
                    NodeList positions = order.getElementsByTagName("position");
                    ArrayList<Position> positionList = new ArrayList<Position>(positions.getLength());
                    for (int k = 0; k < positions.getLength(); k++) {
                        Element position = (Element)positions.item(k);
                        Position p = new Position();
                        if (position.getElementsByTagName("id").item(0).getFirstChild() != null)
                            p.setId(Integer.parseInt(position.getElementsByTagName("id").item(0).getFirstChild().getNodeValue()));
                        else
                            p.setId(null);
                        if (position.getElementsByTagName("price").item(0).getFirstChild() != null)
                            p.setPrice(Double.parseDouble(position.getElementsByTagName("price").item(0).getFirstChild().getNodeValue()));
                        else p.setPrice(null);
                        if (position.getElementsByTagName("count").item(0).getFirstChild() != null)
                            p.setCount(Integer.parseInt(position.getElementsByTagName("count").item(0).getFirstChild().getNodeValue()));
                        else
                            p.setCount(null);
                        positionList.add(p);
                    }
                    o.setPositions(positionList);
                    orderList.add(o);
                }
                temp.setOrders(orderList);
                c.add(temp);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
