import React,{Children, createContext,useState} from "react";
import Cookies from 'js-cookie';


export const AuthContext=createContext();

export const AuthProvider=({children})=>{



    const[isAuth,setIsAuth]=useState(Cookies.get("anyauth")||"");

    const login =( key)=>{
        setIsAuth(key);
    }

    const logout =()=>{
        setIsAuth("");
    }

    return(
        <AuthContext.Provider value={ {isAuth,login,logout}}>

            {children}
        </AuthContext.Provider>
    )
}