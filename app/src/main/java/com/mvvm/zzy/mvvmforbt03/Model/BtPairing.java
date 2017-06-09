package com.mvvm.zzy.mvvmforbt03.Model;

import android.bluetooth.BluetoothDevice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/9 0009.
 */

public class BtPairing {
    /**************************与蓝牙设备配对**************************/
    public static boolean creatBond(Class<? extends BluetoothDevice> btClass, BluetoothDevice btDevice)throws Exception
    {
        Method createbondMethod = btClass.getMethod("createBond");
        Boolean returnValue = (Boolean) createbondMethod.invoke(btDevice);
        return returnValue.booleanValue();
    }
    /*************************************************************/

    /**************************与设备解除配对**************************/
    public static boolean removeBond(Class<? extends BluetoothDevice> btClass, BluetoothDevice btDevice)throws Exception
    {
        Method removeBondMethod = btClass.getMethod("removeBond");
        Boolean returnValue = (Boolean) removeBondMethod.invoke(btDevice);
        return returnValue.booleanValue();
    }
    /*************************************************************/

    /**************************与设备自动配对**************************/
    static public boolean setPin(Class<? extends BluetoothDevice> btClass, BluetoothDevice btDevice, String str) throws Exception
    {
        Method setPinMethod = btClass.getDeclaredMethod("setPin", new Class[]{byte[].class});
        Boolean returnValue = (Boolean) setPinMethod.invoke(btDevice, new Object[]{str.getBytes()});
        return returnValue.booleanValue();
    }
    /*************************************************************/

    /**************************取消用户输入***************************/
    public static boolean cancelPairingUserInput(Class<? extends BluetoothDevice> btClass, BluetoothDevice btDevice) throws Exception
    {
        Method createBondMethod = btClass.getMethod("cancelPairingUserInput");
        Boolean returnValue = (Boolean) createBondMethod.invoke(btDevice);
        return returnValue.booleanValue();
    }
    /*************************************************************/

    /**************************取消设备配对***************************/
    public static boolean cancelBondProcess(Class<? extends BluetoothDevice> btClass, BluetoothDevice btDevice) throws Exception
    {
        Method createBondMethod = btClass.getMethod("cancelBondProcess");
        Boolean returnValue = (Boolean) createBondMethod.invoke(btDevice);
        return returnValue.booleanValue();
    }
    /*************************************************************/

    /**************************打印所有通知***************************/
    public static void printAllInform(Class<? extends BluetoothDevice> clsShow)
    {
    }
    /*************************************************************/
}
