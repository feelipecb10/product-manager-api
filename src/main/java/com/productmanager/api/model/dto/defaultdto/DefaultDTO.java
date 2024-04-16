package com.productmanager.api.model.dto.defaultdto;

import com.productmanager.api.model.entities.defaultentity.DefaultEntity;

import java.time.LocalDateTime;

public class DefaultDTO {

    private boolean active = true;

    private LocalDateTime insertDate;

    private LocalDateTime updateDate;

    public DefaultDTO( ) {
    }

    public DefaultDTO(DefaultEntity entity) {
       this.active = entity.isActive();
       this.insertDate = entity.getInsertDate();
       this.updateDate = entity.getUpdateDate();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

}
