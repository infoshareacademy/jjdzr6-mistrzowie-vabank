package com.infoshareacademy.mistrzowieVaBank.dao;


import com.infoshareacademy.mistrzowieVaBank.dto.*;
import com.infoshareacademy.mistrzowieVaBank.entity.Order;
import com.infoshareacademy.mistrzowieVaBank.entity.OrderDetail;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Transactional
@Repository
public class OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private WineDao wineDao;

    @PersistenceContext
    private EntityManager entityManager;

    private int getMaxOrderNum() {
        String sql = "Select max(o.orderNum) from " + Order.class.getName() + " o ";
        Session session = this.sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery(sql, Integer.class);
        Integer value = (Integer) query.getSingleResult();
        if (value == null) {
            return 0;
        }
        return value;
    }

    @Transactional
    public void saveOrder(CartInfo cartInfo) {
        Session session = this.sessionFactory.getCurrentSession();

        int orderNum = this.getMaxOrderNum() + 1;
        Order order = new Order();

        order.setId(UUID.randomUUID().getMostSignificantBits());
        order.setOrderNum(orderNum);
        order.setOrderDate(LocalDate.now());
        order.setAmount(cartInfo.getAmountTotal());
        order.setRealized(false);

        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        order.setCustomerName(customerInfo.getName());
        order.setCustomerEmail(customerInfo.getEmail());
        order.setCustomerPhone(customerInfo.getPhone());
        order.setCustomerAddress(customerInfo.getAddress());

        session.persist(order);

        List<CartLineInfo> lines = cartInfo.getCartLines();

        for (CartLineInfo line : lines) {
            OrderDetail detail = new OrderDetail();
            detail.setId(UUID.randomUUID().getMostSignificantBits());
            detail.setOrder(order);
            detail.setAmount(line.getAmount());
            detail.setPrice(line.getWineInfo().getPrice());
            detail.setQuantity(line.getQuantity());

            Long id = line.getWineInfo().getId();
            Wine wine = this.wineDao.findWine(id);
            detail.setWine(wine);

            session.persist(detail);
        }

        // Order Number!
        cartInfo.setOrderNum(orderNum);
        // Flush
        session.flush();
    }


    public Order findOrder(int orderId) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Order.class, orderId);
    }

    public Order findOrderByNum(int orderNum) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Order.class, orderNum);
    }


    public OrderInfo getOrderInfo(int orderId) {
        Order order = this.findOrder(orderId);
        if (order == null) {
            return null;
        }
        return new OrderInfo(order.getId(), order.getOrderDate(), //
                order.getOrderNum(), order.getAmount(), order.getCustomerName(), //
                order.getCustomerAddress(), order.getCustomerEmail(), order.getCustomerPhone(), order.getRealized());
    }

    public List<OrderDetailInfo> listOrderDetailInfos(Long orderId) {
        String sql = "Select new " + OrderDetailInfo.class.getName() //
                + "(d.id, d.wine.id, d.wine.name , d.quantity,d.price,d.amount) "//
                + " from " + OrderDetail.class.getName() + " d "//
                + " where d.order.id = :orderId ";

        Session session = this.sessionFactory.getCurrentSession();
        Query<OrderDetailInfo> query = session.createQuery(sql, OrderDetailInfo.class);
        query.setParameter("orderId", orderId);

        return query.getResultList();
    }

    public List<Order> getAllOrders() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> rootEntry = cq.from(Order.class);
        CriteriaQuery<Order> all = cq.select(rootEntry);

        TypedQuery<Order> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public void deleteOrderByOrderNum(int orderNum) {
        this.orderRepository.deleteOrderByOrderNum(orderNum);
    }

    public void setOrderAsRealized(int orderNum) {
        this.orderRepository.setOrderAsRealized(orderNum);
    }

}