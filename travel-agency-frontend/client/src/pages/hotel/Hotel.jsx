import "./hotel.css";
import Navbar from "../../components/navbar/Navbar";
import Header from "../../components/header/Header";
import MailList from "../../components/mailList/MailList";
import Footer from "../../components/footer/Footer";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faCircleArrowLeft, faCircleArrowRight, faCircleXmark, faLocationDot,} from "@fortawesome/free-solid-svg-icons";
import {useContext, useEffect, useState} from "react";
import useFetch from "../../hooks/useFetch";
import {useLocation, useNavigate} from "react-router-dom";
import {SearchContext} from "../../context/SearchContext";
import {AuthContext} from "../../context/AuthContext";
import Reserve from "../../components/reserve/Reserve";

const Hotel = () => {

    const location = useLocation();
    const id = location.pathname.split("/")[2];
    const [slideNumber, setSlideNumber] = useState(0);
    const [open, setOpen] = useState(false);
    const [openModal, setOpenModal] = useState(false);

    const {data, loading, error} = useFetch(`/hotels/${id}`);
    const {user} = useContext(AuthContext);
    const navigate = useNavigate();

    const {dates, options} = useContext(SearchContext);

    const MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;

    function dayDifference(date1, date2) {
        console.log(1);
        const timeDiff = Math.abs(date2.getTime() - date1.getTime());
        const diffDays = Math.ceil(timeDiff / MILLISECONDS_PER_DAY);
        return diffDays;
    }

    const [days, setDays] = useState(0);

    useEffect(() => {
        if (dates[0]) {
            setDays(dayDifference(dates[0].endDate, dates[0].startDate));
        }
    }, [dates])

    const handleOpen = (i) => {
        setSlideNumber(i);
        setOpen(true);
    };

    const handleMove = (direction) => {
        let newSlideNumber;

        if (direction === "l") {
            newSlideNumber = slideNumber === 0 ? 5 : slideNumber - 1;
        } else {
            newSlideNumber = slideNumber === 5 ? 0 : slideNumber + 1;
        }

        setSlideNumber(newSlideNumber);
    };

    const handleClick = () => {
        if (!user) {
            setOpenModal(true);
        } else {
            navigate("/login");
        }
    };

    console.log(data);
    return (
        <div>
            <Navbar/>
            <Header type="list"/>
            {loading ? (
                "Загрузка даних..."
            ) : (
                <div className="hotelContainer">
                    {open && (
                        <div className="slider">
                            <FontAwesomeIcon
                                icon={faCircleXmark}
                                className="close"
                                onClick={() => setOpen(false)}
                            />
                            <FontAwesomeIcon
                                icon={faCircleArrowLeft}
                                className="arrow"
                                onClick={() => handleMove("l")}
                            />
                            <div className="sliderWrapper">
                                <img
                                    src={"http://localhost:8080/files/" + data.images[slideNumber]}
                                    alt=""
                                    className="sliderImg"
                                />
                            </div>
                            <FontAwesomeIcon
                                icon={faCircleArrowRight}
                                className="arrow"
                                onClick={() => handleMove("r")}
                            />
                        </div>
                    )}
                    <div className="hotelWrapper">
                        <button className="bookNow">Забронювати зараз</button>
                        <h1 className="hotelTitle">{data.name}</h1>
                        <div className="hotelAddress">
                            <FontAwesomeIcon icon={faLocationDot}/>
                            <span>{data.address}</span>
                        </div>
                        <span className="hotelPriceHighlight">
              Забронюйте проживання в цьому закладі за ${data.cheapestPrice} і отримайте
               безкоштовне таксі
            </span>
                        <div className="hotelImages">
                            {data.images?.map((photo, i) => (
                                <div className="hotelImgWrapper" key={i}>
                                    <img
                                        onClick={() => handleOpen(i)}
                                        src={"http://localhost:8080/files/" + photo}
                                        alt=""
                                        className="hotelImg"
                                    />
                                </div>
                            ))}
                        </div>
                        <div className="hotelDetails">
                            <div className="hotelDetailsTexts">
                                <h1 className="hotelTitle">Деталі</h1>
                                <p className="hotelDesc">{data.description}</p>
                            </div>
                            <div className="hotelDetailsPrice">
                                <h1>Ідеально для {days} ночей зупинки!</h1>
                                <span>
                  Знаходиться в самому центрі міста це ідіальний вибір
                                </span>
                                <h2>
                                    <b>${days * data.price}</b> ({days}{" "}
                                    ночей)
                                </h2>
                                <button onClick={handleClick}>Забронюйте або забронюйте зараз!</button>
                            </div>
                        </div>
                    </div>
                    <MailList/>
                    <Footer/>
                </div>
            )}
            {openModal && <Reserve setOpen={setOpenModal} hotelId={id}/>}
        </div>
    );
};

export default Hotel;
