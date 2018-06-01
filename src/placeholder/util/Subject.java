/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.util;

/**
 *
 * @author jdolf
 */
public interface Subject<T> {
    void registerListener(T listener);
    void unregisterListener(T listener);
    void notifyListeners();
}
