package com.anrisoftware.geophylo.db.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.AbstractListModel;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.google.inject.persist.Transactional;

@SuppressWarnings("serial")
@Transactional
public class EpochsModel extends AbstractListModel<EpochEntity> {

    public interface EpochsModelFactory {

        EpochsModel create(@Assisted("countQueryName") String countQueryName,
                @Assisted("reportQueryName") String reportQueryName);

        EpochsModel create(@Assisted("countQueryName") String countQueryName,
                @Assisted("reportQueryName") String reportQueryName,
                Map<String, Object> params);

    }

    private final String countQueryName;

    private final String reportQueryName;

    private final Map<String, Object> params;

    @Inject
    private EntityManager em;

    private int currentPage;

    private int maxResults;

    private int pageSize;

    private List<EpochEntity> currentResults;

    @AssistedInject
    EpochsModel(@Assisted("countQueryName") String countQueryName,
            @Assisted("reportQueryName") String reportQueryName) {
        this(countQueryName, reportQueryName, new HashMap<String, Object>());
    }

    @AssistedInject
    EpochsModel(@Assisted("countQueryName") String countQueryName,
            @Assisted("reportQueryName") String reportQueryName,
            @Assisted Map<String, Object> params) {
        this.countQueryName = countQueryName;
        this.reportQueryName = reportQueryName;
        this.pageSize = 0;
        this.currentPage = 0;
        this.params = new HashMap<String, Object>(params);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        Query query = em.createNamedQuery(countQueryName);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        this.maxResults = ((Long) query.getSingleResult()).intValue();
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        this.currentResults = getCurrentResults();
    }

    public int getMaxPages() {
        return maxResults / pageSize;
    }

    @Override
    public int getSize() {
        return maxResults;
    }

    @Override
    public EpochEntity getElementAt(int index) {
        int page = index / pageSize;
        int pageIndex = index % pageSize;
        if (currentPage == page) {
            if (currentResults == null) {
                currentResults = getCurrentResults();
            }
            return currentResults.get(pageIndex);
        } else {
            setCurrentPage(page);
            return getElementAt(index);
        }
    }

    @SuppressWarnings("unchecked")
    public List<EpochEntity> getCurrentResults() {
        Query query = em.createNamedQuery(reportQueryName);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.setFirstResult(currentPage * pageSize)
                .setMaxResults(pageSize).getResultList();
    }
}
