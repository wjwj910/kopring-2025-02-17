package com.ll.global.jpa.entity;

import com.ll.standard.util.Ut;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    @EqualsAndHashCode.Include
    public Long id; // TODO : 추후 private 로 교체

    public String getModelName() {
        String simpleName = this.getClass().getSimpleName();
        return Ut.str.lcfirst(simpleName);
    }
}