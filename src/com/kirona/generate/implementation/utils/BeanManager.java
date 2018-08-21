package com.kirona.generate.implementation.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirona.generate.implementation.database.GenerateDaoImpl;

@Service
public class BeanManager
{


  private static GenerateDaoImpl generatorDaoImpl;

      @Autowired
      public void setGenerator(GenerateDaoImpl generatorDaoImpl) {
          this.generatorDaoImpl = generatorDaoImpl;
      }

      public static GenerateDaoImpl getGenerator() {
          return generatorDaoImpl;
      }

}
