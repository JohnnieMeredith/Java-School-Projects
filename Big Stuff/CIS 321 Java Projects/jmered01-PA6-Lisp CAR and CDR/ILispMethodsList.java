/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package p6;

import java.util.List;

/**
 *
 * @author shasso
 * @param <T>
 */
public interface ILispMethodsList<T> {
    /** 
     * extract the first item from the list and return it 
     * @param obj a list
     * @return the first item in the list
     */
    T car(List<T> obj);

    /**
     * removes the first item from the list, and returns the remaining list
     * @param oList original list
     * @return modified list without the original item
     */
    List<T> cdr(List<T> oList);
}
