import "./newHotel.scss";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import DriveFolderUploadOutlinedIcon from "@mui/icons-material/DriveFolderUploadOutlined";
import {useEffect, useState} from "react";
import axios from "axios";
import {FormControl, Input, MenuItem, Rating, Select} from "@mui/material";
import $api from "../../http";
import {useNavigate} from "react-router-dom";

const AddHotel = () => {

    const [files, setFiles] = useState("");
    const [hotel, setHotel] = useState({});
    const [cities, setCities] = useState([]);

    const [city, setCity] = useState(1);
    const [rating, setRating] = useState();

    const navigate = useNavigate();

    useEffect(() => {
        $api.get("/cities")
            .then(response => {
                setCities(response.data)
            })
            .catch(reason => {
                //toastr.error("Bookstore", "Виникли технічні проблеми");
            });
    }, []);

    const handleChange = (e) => {
        setHotel((prev) => ({...prev, [e.target.id]: e.target.value}));
    };

    console.log(files)

    const handleClick = async (e) => {
        e.preventDefault();
        try {
            /*const list = await Promise.all(
                Object.values(files).map(async (file) => {
                    const data = new FormData();
                    data.append("file", file);
                    data.append("upload_preset", "upload");
                    const uploadRes = await axios.post(
                        "https://api.cloudinary.com/v1_1/lamadev/image/upload",
                        data
                    );

                    const {url} = uploadRes.data;
                    return url;
                })
            );*/
            console.log(1)
            const newhotel = {
                ...hotel,
                cityId: city,
                rating: rating
            };


            console.log(newhotel)
            await $api.post("/hotels", newhotel)
                .then(response => {
                    Object.values(files).map(async (file) => {
                        const data = new FormData();
                        data.append("image", file);
                        await $api.post("/hotels/" + response.data.id, data);
                    });
                });

            navigate("/hotels");
        } catch (err) {
            console.log(err)
        }
    };

    console.log(rating)
    console.log(city)
    console.log(hotel)
    return (
        <div className="new">
            <Sidebar/>
            <div className="newContainer">
                <Navbar/>
                <div className="top">
                    <h1>Add New Product</h1>
                </div>
                <div className="bottom">
                    <div className="left">
                        <img
                            src={
                                files
                                    ? URL.createObjectURL(files[0])
                                    : "https://icon-library.com/images/no-image-icon/no-image-icon-0.jpg"
                            }
                            alt=""
                        />
                    </div>
                    <div className="right">
                        <form>
                            <div className="formInput">
                                <label htmlFor="file">
                                    Image: <DriveFolderUploadOutlinedIcon className="icon"/>
                                </label>
                                <input
                                    type="file"
                                    id="file"
                                    multiple
                                    onChange={(e) => setFiles(e.target.files)}
                                    style={{display: "none"}}
                                />
                            </div>
                            <div className="formInput">
                                <label>Назва</label>
                                <Input
                                    id={"name"}
                                    type={"text"}
                                    placeholder="Мій готель"
                                    onChange={handleChange}
                                />
                            </div>
                            <div className="formInput">
                                <label>Адреса</label>
                                <Input
                                    id={"address"}
                                    type={"text"}
                                    placeholder="Мій готель"
                                    onChange={handleChange}
                                />
                            </div>
                            <div className="formInput">
                                <label>Країна</label>
                                <FormControl sx={{m: 1, minWidth: 120}} size="small">
                                    <Select
                                        id="cityId"
                                        value={city}
                                        onChange={e => setCity(e.target.value)}
                                        style={{width: 200}}
                                    >
                                        {
                                            cities &&
                                            cities.map((city) => (
                                                <MenuItem key={city.id} value={city.id}>
                                                    {city.name + ", " + city.country}
                                                </MenuItem>
                                            ))
                                        }
                                    </Select>
                                </FormControl>
                            </div>
                            <div className="formInput">
                                <label>Rating</label>
                                <Rating
                                    id="rating"
                                    value={hotel.rating}
                                    onChange={e => setRating(e.target.value)}
                                />
                            </div>
                            <div className="formInput">
                                <label>Додаткова інформація</label>
                                <Input
                                    id={"description"}
                                    type={"text"}
                                    multiline
                                    placeholder="Додаткова інформація"
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

export default AddHotel;
