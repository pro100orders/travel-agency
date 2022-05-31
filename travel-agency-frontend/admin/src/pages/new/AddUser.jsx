import "./AddUser.scss";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import {useState} from "react";
import $api from "../../http";
import {useNavigate} from "react-router-dom";
import {Input} from "@mui/material";

const AddUser = () => {

    const [user, setUser] = useState({});

    const navigate = useNavigate();

    const handleChange = (e) => {
        setUser((prev) => ({...prev, [e.target.id]: e.target.value}));
    };

    const handleClick = async (e) => {
        console.log(1);
        e.preventDefault();
        $api.post("/registration", user)
            .then(() => {
                navigate("/users");
            })
            .catch(reason => {
                console.log(reason);
            });
    };

    return (
        <div className="new">
            <Sidebar/>
            <div className="newContainer">
                <Navbar/>
                <div className="top">
                    <h1>Додавання користувача</h1>
                </div>
                <div className="bottom">
                    <div className="right">
                        <form>
                            <div className="formInput">
                                <label>Прізвище</label>
                                <Input
                                    id={"surname"}
                                    type={"text"}
                                    placeholder="Ясенівський"
                                    onChange={handleChange}
                                />
                            </div>
                            <div className="formInput">
                                <label>Ім'я</label>
                                <Input
                                    id={"name"}
                                    type={"text"}
                                    placeholder="Віталій"
                                    onChange={handleChange}
                                />
                            </div>
                            <div className="formInput">
                                <label>Пошта</label>
                                <Input
                                    id={"email"}
                                    type={"text"}
                                    placeholder="bt769271@gmail.com"
                                    onChange={handleChange}
                                />
                            </div>
                            <div className="formInput">
                                <label>Номер телефону</label>
                                <Input
                                    id={"phone"}
                                    type={"text"}
                                    placeholder="+380972553991"
                                    onChange={handleChange}
                                />
                            </div>
                            <div className="formInput">
                                <label>Пароль</label>
                                <Input
                                    id={"password"}
                                    type={"password"}
                                    onChange={handleChange}
                                />
                            </div>
                            <button onClick={handleClick}>Send</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AddUser;
