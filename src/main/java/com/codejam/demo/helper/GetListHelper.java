package com.codejam.demo.helper;

import com.codejam.demo.enums.RecordStatus;
import com.codejam.demo.service.BaseService;
import com.codejam.demo.utils.PaginationParameters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

import static com.codejam.demo.utils.StringUtils.isNotEmpty;

public class GetListHelper<T> extends BaseService {

    final Class<T> typeParameterClass;
    private final EntityManager em;

    public GetListHelper(EntityManager em, Class<T> typeParameterClass) {
        this.em = em;
        this.typeParameterClass = typeParameterClass;
    }

    public Pageable getPageable(String sortBy, int page, int size) {
        Pageable pageable;
        if (sortBy.isEmpty()) pageable = PageRequest.of(page - 1, size);
        else {
            String[] parts = sortBy.split(",");
            pageable = PageRequest.of(page - 1, size, Sort.by(parts[0]));
            if (parts[1].equals("desc")) pageable = PageRequest.of(page - 1, size, Sort.by(parts[0]).descending());
        }
        return pageable;
    }

    public Map<String, Object> getList(Page<T> result, Integer page, Integer size) {
        Long total = result.getTotalElements();
        Map<String, Object> maps = new HashMap<>();
        PaginationParameters.getdata(maps, page, total, size, result.getContent());
        return maps;
    }

    public List<T> findAll(String[] sortable, String sortBy) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(typeParameterClass);
        Root<T> root = query.from(typeParameterClass);
        query.select(root);

        if (isNotEmpty(sortBy)) {
            String[] sortByArr = sortBy.split(",");
            logger.info(String.valueOf(sortByArr[1].equals("desc")));
            if (sortByArr.length <= 2 && Arrays.asList(sortable).contains(sortByArr[0])) {
                if (sortByArr[1].equals("desc")) {
                    query.orderBy(cb.desc(root.get(sortByArr[0])));
                } else {
                    query.orderBy(cb.asc(root.get(sortByArr[0])));
                }
            }
        }

        TypedQuery<T> tQuery = em.createQuery(query);

        return tQuery.getResultList();
    }

    public List<T> findAll(String[] sortable, String sortBy, Map<String, Object> filterMap) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(typeParameterClass);
        Root<T> root = query.from(typeParameterClass);
        query.select(root);

        List<Predicate> predicates = new ArrayList<>();

        deleteParam(cb, query, root, predicates);

        if (filterMap.size() > 0) {
            for (String key : filterMap.keySet()) {
                if ((filterMap.get(key)) instanceof Integer) {
                    if (!filterMap.get(key).equals(0))
                        predicates.add(cb.equal(root.get(key), filterMap.get(key)));
                } else if ((filterMap.get(key)) instanceof Double) {
                    if (!filterMap.get(key).equals(0))
                        predicates.add(cb.equal(root.get(key), filterMap.get(key)));
                } else if ((filterMap.get(key)) instanceof Long) {
                    if (!filterMap.get(key).equals(0))
                        predicates.add(cb.equal(root.get(key), filterMap.get(key)));
                } else if ((filterMap.get(key)) instanceof String) {
                    if (!filterMap.get(key).equals(""))
                        predicates.add(cb.equal(root.get(key), String.valueOf(filterMap.get(key))));
                } else if ((filterMap.get(key)) instanceof Enum) {
                    if (!filterMap.get(key).equals(""))
                        predicates.add(cb.equal(root.get(key), filterMap.get(key)));
                }
            }
            if ((filterMap.get("date")) instanceof Date) {
                if (!filterMap.get("date").equals("")) {

                    predicates.add(cb.between(root.get("date"), new Date(), new Date()));
                    cb.between(root.get("dateEntry"), new Date(), new Date());
                }
//                    predicates.add(cb.equal(root.get(key), filterMap.get(key)));
            }
            query.where(cb.and(predicates.toArray(new Predicate[]{})));
        }

        if (isNotEmpty(sortBy)) {
            String[] sortByArr = sortBy.split(",");
            logger.info(String.valueOf(sortByArr[1].equals("desc")));
            if (sortByArr.length <= 2 && Arrays.asList(sortable).contains(sortByArr[0])) {
                if (sortByArr[1].equals("desc")) {
                    query.orderBy(cb.desc(root.get(sortByArr[0])));
                } else {
                    query.orderBy(cb.asc(root.get(sortByArr[0])));
                }
            }
        }

        TypedQuery<T> tQuery = em.createQuery(query);

        return tQuery.getResultList();
    }

    public void deleteParam(CriteriaBuilder cb, CriteriaQuery<?> query, Root<?> root, List<Predicate> predicates) {
        predicates.add(cb.notEqual(root.get("recordStatus"), RecordStatus.DELETED));
        query.where(cb.and(predicates.toArray(new Predicate[]{})));
    }
}
