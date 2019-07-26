package org.springframework.luozlspringtest.springsource.spring41;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public interface AccountServiceImpNew {
    void save() throws RuntimeException;
}
