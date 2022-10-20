package com.pawn_shop.service.impl;

import com.pawn_shop.model.pawn.PawnType;
import com.pawn_shop.repository.IPawnTypeRepository;
import com.pawn_shop.service.IPawnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PawnTypeService implements IPawnTypeService {

<<<<<<< HEAD

=======
    @Autowired
    private IPawnTypeRepository iPawnTypeRepository;

    @Override
    public List<PawnType> findAllPawnType() {
        return iPawnTypeRepository.findAllPawnType();
    }
>>>>>>> bba05b2ddf91be359030c53a8e609456592c23a5
}
